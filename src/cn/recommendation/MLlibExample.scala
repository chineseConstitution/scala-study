package cn.recommendation

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation._

object MLlibExample {
  def main(args: Array[String]): Unit = {

    //设置运行环境
    val sparkConf = new SparkConf().setAppName("MLlibExample").setMaster("local[5]")
    val sc = new SparkContext(sparkConf)

    /**
     * 步骤1、首先读取评分数据，保存为RDD[String]对象
     */
    val data = sc.textFile("E://learning//spark//软件包//spark-1.3.0-bin-hadoop2.4//data//mllib//als//test.data")
    val ratings = data.map(_.split(",") match {
      case Array(user, item, rate) => Rating(user.toInt, item.toInt, rate.toDouble)
    })

    /**
     * 步骤2、使用ALS算法求解矩阵分解
     */
    //设置按秩为10进行矩阵分解
    val rank = 10
    //设置迭代次数为20次
    val numIterations = 20
    //设置矩阵分解的正则系数为0.01
    val alpha = 0.01

    val model = ALS.train(ratings, rank, numIterations, alpha)

    /**
     * 步骤3、利用训练结果预测一些用户评分
     */

    //预测用户1对项目1的评分
    println("Rating of user1 towards item1 is: " + model.predict(1, 1))
    //预测用户1最感兴趣的2个项目
    model.recommendProducts(1, 2).foreach { rating =>
      println("Product " + rating.product + " Rating=" + rating.rating)
    }

    /**
     * 步骤4、最后，可以计算一下矩阵分解结果和训练数据之间的均方误差
     */

    //获得预测结果和原始评分
    val usersProducts = ratings.map {
      case Rating(user, product, rate) => (user, product)
    }

    val predictions = model.predict(usersProducts).map {
      case Rating(user, product, rate) => ((user, product), rate)
    }
    
    val ratesAndPreds = ratings.map { 
      case Rating(user, product, rate) => ((user, product), rate)
    }.join(predictions)
    
    //计算均方误差
    val MSE = ratesAndPreds.map{
      case ((user, product), (r1, r2)) => 
        val err = (r1 - r2)
        err * err
    }.mean()
    
    println("Mean Squared Error = " + MSE)

  }
}