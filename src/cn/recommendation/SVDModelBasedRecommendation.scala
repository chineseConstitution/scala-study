package cn.recommendation

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix

object SVDModelBasedRecommendation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
        .setAppName("ModelBasedRecommendation")
        .setMaster("local")

      val sc = new SparkContext(conf)

      //1、读取评分数据
      val data = sc.textFile("E://learning//spark//软件包//spark-1.3.0-bin-hadoop2.4//data//mllib//als//test.data")
      val persedData = data.map(_.split(',') match {
        case Array(user, item, rate) => MatrixEntry(user.toLong - 1, item.toLong - 1, rate.toDouble)
      })
      val ratings = new CoordinateMatrix(persedData)
      //2、将CoordinateMatrix转换为RowMatrix，并调用computerSVD计算评分矩阵的秩为2的奇异值分解
      val matrix = ratings.toRowMatrix
      val svd = matrix.computeSVD(2, true)
      //3、假设需要预测用户1对项目1的评分，则需要计算...（见Spark大数据分析实战P155）
      val score = (0 to 1).map(t => svd.U.rows.toArray()(0)(t) * svd.V.transpose.toArray(t))
      println("Rating of user1 towards item1 is: " + score.sum * svd.s(0))
  }
}