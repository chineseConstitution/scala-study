package cn.mllib.cluster.kmeans

import org.apache.log4j.{ Logger, Level }
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.clustering.KMeans

object Kmeans {
  def main(args: Array[String]): Unit = {

    val args = Array("E://learning//eclipse//workspace//spark-1.3.0//data//mllib//kmeans_data.txt")

    //屏蔽不必要的日志显示在终端上

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    Logger.getLogger("org.apache.eclipse.jetty.server").setLevel(Level.OFF)

    //设置运行环境

    val sparkConf = new SparkConf().setAppName("Kmeans").setMaster("local[5]")

    val sc = new SparkContext(sparkConf)

    //步骤1：将数据集读取到RDD[Vector]对象中
    val kmeansData = args(0)
    val data = sc.textFile(kmeansData);
    val parsedData = data.map(s => Vectors.dense(s.split(" ").map(_.toDouble))).cache()
    //步骤2：设置K均值算法的参数k=2，最大迭代次数为20，求解聚类结果
    val clusters = new KMeans().setK(2).setMaxIterations(20).run(parsedData);
    //步骤3：输出聚类的中心
    (0 to 1).foreach { id =>
      println("Center of cluster " + (id + 1) + " is " + clusters.clusterCenters(id))
    }
    //步骤4：输出聚类结果的类的平方误差之和
    println("Within Set Sum of Squared Errors = " + clusters.computeCost(parsedData))
    //步骤5：假设需要利用聚类结果预测坐标[0.5,0.9,0.8]所属的聚类
    val point = Vectors.dense(Array(0.5, 0.9, 0.8))
    println("Point " + point + " belongs to cluster " + (clusters.predict(point) + 1))
  }
}