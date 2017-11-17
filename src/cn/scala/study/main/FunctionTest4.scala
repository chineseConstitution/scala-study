package cn.scala.study.main

import scala.io.Source._

/**
 * 	函数入门之过程、lazy值
 */
object FunctionTest4 {
  def main(args: Array[String]): Unit = {

    //val lines = fromFile("C://Users//Administrator//Desktop//test.txt").mkString

    //即使文件不存在，也不会报错，只有第一个使用变量时会报错，证明了表达式计算的lazy特性。
    // lazy val lines = fromFile("C://Users//Administrator//Desktop//test.txt").mkString

    def lines = fromFile("C://Users//Administrator//Desktop//test.txt").mkString

  }

  //def sayHello(name:String) = "Hello," + name

  //在Scala中，定义函数时，如果函数体直接包裹在了花括号里面，而没有使用=连接
  //则函数的返回值类型就是Unit。这样的函数就被称之为过程。过程通常用于不需要返回值的函数。
  //过程还有一种写法，就是将函数的返回值类型定义为Unit。
  //def sayHello(name:String) {print("Hello," + name); "Hello," + name}
  def sayHello(name: String): Unit = "Hello," + name;
}