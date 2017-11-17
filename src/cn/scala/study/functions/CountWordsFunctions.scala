package cn.scala.study.functions

/**
 * 6、函数式编程综合案例：统计多个文本内的单词总数
 */
object CountWordsFunctions {
  def main(args: Array[String]): Unit = {
    // 使用scala的io包将文本文件内的数据读取出来
    val lines01 = scala.io.Source.fromFile("C://Users//Administrator//Desktop//test01.txt").mkString
    val lines02 = scala.io.Source.fromFile("C://Users//Administrator//Desktop//test02.txt").mkString
    // 使用List的伴生对象，将多个文件内的内容创建为一个List
    val lines = List(lines01, lines02)

    // 下面这一行才是我们的案例的核心和重点，因为有多个高阶函数的链式调用，以及大量下划线的使用，如果没有透彻掌握之前的课讲解的Scala函数式编程，那么下面这一行代码，完全可能会看不懂！！！
    // 但是下面这行代码其实就是Scala编程的精髓所在，就是函数式编程，也是Scala相较于Java等编程语言最大的功能优势所在
    // 而且，spark的源码中大量使用了这种复杂的链式调用的函数式编程
    // 而且，spark本身提供的开发人员使用的编程api的风格，完全沿用了Scala的函数式编程，比如Spark自身的api中就提供了map、flatMap、reduce、foreach，以及更高级的reduceByKey、groupByKey等高阶函数
    // 如果要使用Scala进行spark工程的开发，那么就必须掌握这种复杂的高阶函数的链式调用！！！

    val counts = lines.flatMap(_.split(" ")).map((_, 1)).map(_._2).reduceLeft(_ + _)
    
    println(counts)
  }
}