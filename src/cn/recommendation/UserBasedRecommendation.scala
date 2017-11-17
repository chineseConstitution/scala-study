package cn.recommendation

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix

object UserBasedRecommendation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("UserBasedRecommendation")
      .setMaster("local")

    val sc = new SparkContext(conf)

    /**
     * 步骤一、将评分数据读取到CoordinateMatrix
     */
    val data = sc.textFile("E://learning//spark//软件包//spark-1.3.0-bin-hadoop2.4//data//mllib//als//test.data")
    val persedData = data.map(_.split(',') match {
      case Array(user, item, rate) => MatrixEntry(user.toLong - 1, item.toLong - 1, rate.toDouble)
    })
    val ratings = new CoordinateMatrix(persedData)

    /**
     * 步骤二、将CoordinateMatrix转换为RowMatrix计算两两用户的余弦相似度。
     * 由于RowMatrix只能就是那列的相似度，而用户数据是有行表示，因此CoordinateMatrix需要先计算转置
     */
    val matrix = ratings.transpose.toRowMatrix
    val similarities = matrix.columnSimilarities(0.1)

    /**
     * 步骤三、假设需要预测用户1对项目1的评分，那么预测结果就是用户1的平均评分加上其他用户对项目1评分的按相似度的加权平均
     */

    //计算用户1的平均评分
    val ratingsOfUser1 = ratings.toRowMatrix.rows.toArray()(0).toArray
    val avgRatingOfUser1 = ratingsOfUser1.sum / ratingsOfUser1.size
    //计算其他用户对项目1的加权平均评分
    val ratingsToItem1 = matrix.rows.toArray()(0).toArray.drop(1)
    val weights = similarities.entries.filter(_.i == 0).sortBy(_.j).map(_.value).collect
    var weightedR = (0 to 2).map(t => weights(t) * ratingsToItem1(t)).sum / weights.sum
    //求和输出预测结果
    println("Rating of user1 towards item1 is: " + (avgRatingOfUser1 + weightedR))

  }
}