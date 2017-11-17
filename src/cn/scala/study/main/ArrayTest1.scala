package cn.scala.study.main

// 如果不想每次都使用全限定名，则可以预先导入ArrayBuffer类
import scala.collection.mutable.ArrayBuffer

/**
 * 数组操作之Array、ArrayBuffer以及遍历数组
 */
object ArrayTest1 {
  /**
   * 在Scala中，Array代表的含义与Java中类似，也是长度不可改变的数组。
   * 此外，由于Scala与Java都是运行在JVM中，双方可以互相调用，因此Scala数组的底层实际上是Java数组。
   * 例如字符串数组在底层就是Java的String[]，整数数组在底层就是Java的Int[]。
   *
   */
  def main(args: Array[String]): Unit = {
    //    //数组初始化后，长度就固定下来了，而且元素全部根据其类型初始化
    //    val a = new Array[Int](10)
    //    println(a(0))
    //    a(0) = 1;
    //    println(a(0))

    //    // 可以直接使用Array()创建数组，元素类型自动推断
    //    val a = Array("Hello","world")
    //    println(a(0))
    //    a(0) = "hi"
    //    println(a(0))

    //    val a = Array("leo", 30)
    //    println(a(0) + "," + a(1))

        val a = Array(5, 1, 3, 4, 2)
        // 使用ArrayBuffer()的方式可以创建一个空的ArrayBuffer
        val b = ArrayBuffer[Int]()
        // 使用+=操作符，可以添加一个元素，或者多个元素
        b += 1
        b += (2, 3, 4, 5)
        // 使用++=操作符，可以添加其他集合中的所有元素
        b ++= Array(6, 7, 8, 9, 10)
        // 使用trimEnd()函数，可以从尾部截断指定个数的元素
        b.trimEnd(5)
        // 使用insert()函数可以在指定位置插入元素
        // 但是这种操作效率很低，因为需要移动指定位置后的所有元素
        b.insert(5, 6)
        b.insert(6, 7, 8, 9, 10)
        // 使用remove()函数可以移除指定位置的元素
        b.remove(1)
        b.remove(1, 3)
        // Array与ArrayBuffer可以互相进行转换
        b.toArray
        a.toBuffer
        // 使用for循环和until遍历Array / ArrayBuffer
        // 使until是RichInt提供的函数
        for (i <- 0 until b.length)
          println(b(i))
        // 跳跃遍历Array / ArrayBuffer
        for (i <- 0 until (b.length, 2))
          println(b(i))
        // 从尾部遍历Array / ArrayBuffer
        for (i <- (0 until b.length).reverse)
          println(b(i))
        // 使用“增强for循环”遍历Array / ArrayBuffer
        for (e <- b)
          println(e)
    
        //数组元素求和
        val sum = a.sum
        println("sum:" + sum)
        // 获取数组最大值
        val max = a.max
        println("max:" + max)
        // 对数组进行排序
        scala.util.Sorting.quickSort(a)
        // 获取数组中所有元素内容
        println(a.mkString)
        println(a.mkString(", "))
        println(a.mkString("<", ",", ">"))
        // toString函数
        println(a.foreach { print(_) })
        println(b.toString)

  }
}