package cn.recommendation

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.Rating
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.recommendation.ALS
import scala.io.Source
import org.apache.log4j.Logger
import org.apache.log4j.Level

object ALSMoviesRecommendation {
  def main(args: Array[String]): Unit = {
    val args = Array("E://learning//ml-1m/", "E://learning//ml-1m//myRatings.dat")

    //屏蔽不必要的日志显示在终端上
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.apache.eclipse.jetty.server").setLevel(Level.OFF)

    //设置运行环境
    val conf = new SparkConf()
      .setAppName("ALSMoviesRecommendation")
      .setMaster("local[5]")
    val sc = new SparkContext(conf)

    //装载用户评分,即文件myRatings.dat
    val myRatings = loadRatings(args(1))
    val myRatingsRDD = sc.parallelize(myRatings, 1)
    
    //样本数据库
    val movieLensHomeDir = args(0)

    /**
     * 步骤一、 首先读取电影和评分数据
     */
    //1、读取电影信息到本地
    val movies = sc.textFile(movieLensHomeDir + "/movies.dat").map { line =>
      val fields = line.split("::")
      (fields(0).toInt, fields(1))
    }.collect().toMap

    //2、读取评分数据为RDD[Rating]
    val ratings = sc.textFile(movieLensHomeDir + "/ratings.dat").map { line =>
      val fields = line.split("::")
      val rating = Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
      val timestamp = fields(3).toLong % 10
      (timestamp, rating)
    }

    //3、输出数据基本信息
    val numRatings = ratings.count
    val numUsers = ratings.map(_._2.user).distinct.count
    val numMovies = ratings.map(_._2.product).distinct.count
    println("Got " + numRatings + " ratings from " + numUsers + " users on " + numMovies + " movies.")

    /**
     * 步骤二、利用timestamp将数据集风味训练集(timpstamp<6，并加入用户评分)、验证集(6<=timestamp<8)和测试集(timestamp>8)
     */
    val training = ratings.filter(x => x._1 < 6).values.union(myRatingsRDD).repartition(4).cache()
    val validation = ratings.filter(x => x._1 >= 6 && x._1 < 8).values.repartition(4).cache()
    val test = ratings.filter(x => x._1 >= 8).values.cache()

    val numTraining = training.count
    val numValidation = validation.count
    val numTest = test.count
    println("Training: " + numTraining + ",validation: " + numValidation + ",test:" + numTest)

    /**
     * 步骤四、使用不同的参数训练协同过滤模型,并且选择出RMSE最小的模型(为了简单起见，只从一个较小的参数范围选择：
     * 矩阵分解的秩从8-12中选择，正则系数从1.0-10.0中选择，迭代次数从10-20中选择，
     * 共计8个模型。可以根据实际需求选择范围)
     */
    val ranks = List(8, 12)
    val lambdas = List(0.1, 10.0)
    val numIters = List(10, 20)
    var bestModel: Option[MatrixFactorizationModel] = None

    var bestValidationRmse = Double.MaxValue
    var bestRank = 0
    var bestLambda = -1.0
    var bestNumIter = -1
    for (rank <- ranks; lambda <- lambdas; numIter <- numIters) {
      val model = ALS.train(training, rank, numIter, lambda)
      val validationRmse = computeRmse(model, validation)
      if (validationRmse < bestValidationRmse) {
        bestModel = Some(model)
        bestValidationRmse = validationRmse
        bestRank = rank
        bestLambda = lambda
        bestNumIter = numIter
      }
    }

    val testRmse = computeRmse(bestModel.get, test)
    /**
     * 训练所有的模型需要花费一些时间，参数的选择范围越大，训练的时间越长，最后，程序选择的最佳模型是：
     * 秩为8，正则系数为10.0，迭代次数为20。
     */
    println("The best model was trained with rank = " + bestRank +
      " and lambda = " + bestLambda +
      " and numIter = " + bestNumIter +
      " and its RMSE on the best set is " + testRmse + ".")

    /**
     * 步骤五、同时，还可以对比使用协同过滤算法和不使用协同过滤算法(例如，使用平均分来作为预测结果)能得到多大的预测效果提升
     */
    val meanR = training.union(validation).map { _.rating }.mean
    val baseRmse = math.sqrt(test.map(x => (meanR - x.rating) * (meanR - x.rating)).mean)
    val improvement = (baseRmse - testRmse) / baseRmse * 100
    println("The best model improves the baseline by " + "%1.2f".format(improvement) + "%.")

    /**
     * 得到最佳模型后，可以使用该模型来推荐电影
     */
    //装载用户评分文件myRatings.dat

    val myRatedMovieIds = myRatings.map(_.product).toSet
    val cands = sc.parallelize(movies.keys.filter(!myRatedMovieIds.contains(_)).toSeq)
    val recommendations = bestModel.get.predict(cands.map((0, _))).collect().sortBy(-_.rating).take(10)

    var i = 1
    println("Movies recommended for you:")
    recommendations.foreach { r =>
      println("%2d".format(i) + ": " + movies(r.product))
      i += 1
    }
  }

  /**
   * 步骤三、定义函数计算均方误差RMSE
   */
  def computeRmse(model: MatrixFactorizationModel, data: RDD[Rating]): Double = {
    val predictions: RDD[Rating] = model.predict(data.map(x => (x.user, x.product)))
    val predictionsAndRatings = predictions.map { x =>
      ((x.user, x.product), x.rating)
    }.join(data.map(x => ((x.user, x.product), x.rating))).values

    math.sqrt(predictionsAndRatings.map(x => (x._1 - x._2) * (x._1 - x._2)).mean())
  }
  
  /**
   * 装载用户评分文件myRatings.dat
   */
  def loadRatings(path: String):Seq[Rating] = {
    val lines = Source.fromFile(path).getLines()
    val ratings = lines.map { 
      line =>
        val fields = line.split("::")
        Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
    }.filter(_.rating > 0.0)
    
    if (ratings.isEmpty) {
      sys.error("No ratings provided")
    }else{
      ratings.toSeq
    }
  }

}