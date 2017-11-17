package cn.scala.study.functions

object FunctionTest1 {
  // Scala中的函数是一等公民，可以独立定义，独立存在，而且可以直接将函数作为值赋值给变量
  //1、将函数赋值给变量
  def sayHello(name: String) { println("Hello, " + name) }
  // Scala的语法规定，将函数赋值给变量时，必须在函数后面加上空格和下划线
  //val sayHelloFunc = sayHello _

  // 2、匿名函数
  // Scala中，函数也可以不需要命名，此时函数被称为匿名函数。
  // 可以直接定义函数之后，将函数赋值给某个变量；也可以将直接定义的匿名函数传入其他函数之中
  // Scala定义匿名函数的语法规则就是，(参数名: 参数类型) => 函数体
  // 这种匿名函数的语法必须深刻理解和掌握，在spark的中有大量这样的语法，如果没有掌握，是看不懂spark源码的
  val sayHelloFunc = (name: String) => println("Hello," + name)

  // 3、高阶函数
  // Scala中，由于函数是一等公民，因此可以直接将某个函数传入其他函数，作为参数。这个功能是极其强大的，也是Java这种面向对象的编程语言所不具备的。
  // 接收其他函数作为参数的函数，也被称作高阶函数（higher-order function）
  def greeting(func: (String) => Unit, name: String) { func(name) }

  // 高阶函数的另外一个功能是将函数作为返回值
  def getGreetingFunc(msg: String) = (name: String) => println(msg + "," + name)

  def main(args: Array[String]): Unit = {
    sayHelloFunc("leo")

    //greetingFunc的作用是接收不同的msg，返回不同的函数。
    greeting(sayHelloFunc, "leo")

    Array(1, 2, 3, 4, 5).map { (num: Int) => num * num }

    //val greetingFunc = getGreetingFunc("Hello")
    //greetingFunc("leo")

    val greetingFunc = getGreetingFunc("Hi")
    greetingFunc("leo")

  }
}