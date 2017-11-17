package cn.scala.study.functions

object CurryingFunction {
  def main(args: Array[String]): Unit = {
    // 8、Currying函数
    // Curring函数，指的是，将原来接收两个参数的一个函数，转换为两个函数，第一个函数接收原先的第一个参数，然后返回接收原先第二个参数的第二个函数。
    // 在函数调用的过程中，就变为了两个函数连续调用的形式
    // 在Spark的源码中，也有体现，所以对()()这种形式的Curring函数，必须掌握！
    println(sum(1,1))
    
    println(sum2(1)(1))
    
    println(sum3(1)(1))

  }
  
  def sum(a:Int, b:Int) = a + b
  
  // Curring函数，指的是，将原来接收两个参数的一个函数，转换为两个函数，第一个函数接收原先的第一个参数，然后返回接收原先第二个参数的第二个函数。
  def sum2(a:Int) = (b:Int) => a + b
  
  def sum3(a:Int)(b:Int) = a + b
}