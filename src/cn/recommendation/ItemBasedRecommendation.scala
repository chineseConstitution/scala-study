package cn.recommendation

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix

object ItemBasedRecommendation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("ItemBasedRecommendation")
      .setMaster("local")

    val sc = new SparkContext(conf)

    //读取评分数据
    val data = sc.textFile("E://learning//spark//软件包//spark-1.3.0-bin-hadoop2.4//data//mllib//als//test.data")
    val persedData = data.map(_.split(',') match {
      case Array(user, item, rate) => MatrixEntry(user.toLong - 1, item.toLong - 1, rate.toDouble)
    })
    val ratings = new CoordinateMatrix(persedData)

    //计算Item相似度
    val similarities = ratings.toRowMatrix.columnSimilarities(0.1)
    
    //计算项目1的平均评分
    val ratingsOfItem1 = ratings.transpose.toRowMatrix.rows.toArray()(0).toArray
    val avgRatingOfItem1 = ratingsOfItem1.sum / ratingsOfItem1.size
    //计算用户1对其他项目的加权平均评分？
    val matrix = ratings.transpose.toRowMatrix
    val ratingsToItem1 = matrix.rows.toArray()(0).toArray.drop(1)
    
    val ratingsOfUser1 = ratings.toRowMatrix.rows.toArray()(0).toArray.drop(1)
    val weights = similarities.entries.filter(_.i == 0).sortBy(_.j).map(_.value).collect
    var weightedR = (0 to 2).map(t => weights(t) * ratingsToItem1(t)).sum / weights.sum
    //求和输出预测结果
    println("Rating of user1 towards item1 is: " + (avgRatingOfItem1 + weightedR))

  }
}