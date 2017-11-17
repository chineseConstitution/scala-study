package cn.scala.study.advanced.multidimensionalarray

object multidimensionalArray {
  def main(args: Array[String]): Unit = {

    //1、多维数组
    //构造指定行与列的二维数组：Array.ofDim方法
    val multiDimArr1 = Array.ofDim[Double](3, 4)
    multiDimArr1(0)(0) = 1.0
    println("multiDimArr1.length=" + multiDimArr1.length)
    println("multiDimArr1(0).length=" + multiDimArr1(0).length)
    for (i <- 0 until multiDimArr1.length) {
      for (j <- 0 until multiDimArr1(0).length) {
        print(multiDimArr1(i)(j) + " ")
      }
      println()
    }

    //构造不规则多维数组：
    val multiDimArr2 = new Array[Array[Int]](3)
    multiDimArr2(0) = new Array[Int](1)
    multiDimArr2(1) = new Array[Int](2)
    multiDimArr2(2) = new Array[Int](3)
    multiDimArr2(1)(1) = 1
    println("multiDimArr2.length=" + multiDimArr2.length)
    println("multiDimArr2(0).length=" + multiDimArr2(0).length)
    for (i <- 0 until multiDimArr2.length) {
      for (j <- 0 until multiDimArr2(i).length) {
        print(multiDimArr2(i)(j) + " ")
      }
      println()
    }

    //2、Java数组与Scala数组缓冲的隐式转换
    //Scala代码中，直接调用JDK（Java）的API，比如调用一个Java类的方法，势必可能会传入Java类型的list；Scala中构造出来的list，其实是ArrayBuffer；你直接把Scala的ArrayBuffer传入Java接收ArrayList的方法，肯定不行。

    import scala.collection.JavaConversions.bufferAsJavaList
    import scala.collection.mutable.ArrayBuffer

    val command = ArrayBuffer("javac", "C:\\Users\\Administrator\\Desktop\\HelloWorld.java")
    val processBuilder = new ProcessBuilder(command)
    val process = processBuilder.start()
    val res = process.waitFor()

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer

    val cmd: Buffer[String] = processBuilder.command()

  }
}