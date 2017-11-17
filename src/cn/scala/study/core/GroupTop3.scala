package cn.spark.study.core

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.util.control.Breaks._

object GroupTop3 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("GroupTop3")
      .setMaster("local")

    val sc = new SparkContext(conf)

    val lines = sc.textFile("C://Users//Administrator//Desktop//test//score.txt", 1)
    val pairs = lines.map { line => Tuple2(line.split(" ")(0), line.split(" ")(1).toInt) }
    val groupPairs = pairs.groupByKey()
    val top3Score = groupPairs.map(classScores => {
      val top3 = Array[Int](-1,-1,-1)
      val className = classScores._1
      val scores = classScores._2

      for (score <- scores) {
        breakable {
          for (i <- 0 until 3) {
            if (top3(i) == -1) {
              top3(i) = score
              break
            } else if (score > top3(i)) {
              var j = 2
              while (j > i) {
                top3(j) = top3(j - 1)
                j = j - 1
              }
              top3(i) = score
              break
            }
          }
        }
      }
      (className, top3)
    })

    top3Score.foreach(x => {
      println(x._1)
      val res = x._2
      for (i <- res) {
        println(i)
      }
      println("==========================")
    })

  }
}