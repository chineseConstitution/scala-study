package cn.scala.study.main

object LoopTest {
  def main(args: Array[String]): Unit = {
    var n = 10
    //    //1、while do循环：Scala有while do循环，基本语义与Java相同
    //    while(n > 0){
    //      println(n)
    //      n -= 1
    //    }

    //    //2、Scala没有for循环，只能使用while替代for循环，或者使用简易版的for语句
    //    for(i <- 1 to n) println(i)
    //    //使用until，表式不达到上限
    //    for(i <- 1 until n) println(i)
    //    //可以对字符串进行遍历，类似于java的增强for循环
    //    for(i <- "Hello World") print(i)

    //    //3、跳出循环语句，scala没有提供类似于java的break语句。
    //    //但是可以使用boolean类型变量、return或者Breaks的break函数来替代使用
    //    import scala.util.control.Breaks._
    //
    //    breakable {
    //      var n = 10
    //      for (c <- "Hello World") {
    //        if (n == 5) break;
    //        print(c)
    //        n -= 1
    //      }
    //    }

    //    /**
    //     * 高级for循环
    //     */
    //    //4、多重for循环，九九乘法表
    //    for (i <- 1 to 9; j <- 1 to 9) {
    //      if (j == 9) {
    //        println(i + "*" + j + "=" + i * j + "  ")
    //      } else {
    //        print(i + "*" + j + "=" + i * j + "  ")
    //      }
    //    }

    //    //5、if守卫：取偶数
    //    for (i <- 1 to 100 if i % 2 == 0) println(i)

    //6、for推导式：构造集合
    var set = for (i <- 1 to 10) yield i
    println(set)
  }
}