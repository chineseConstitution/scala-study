package cn.scala.study.functions

object Closure {
  def main(args: Array[String]): Unit = {
    // 6、闭包
    // 闭包最简洁的解释：函数在变量不处于其有效作用域时，还能够对变量进行访问，即为闭包
    // 两次调用getGreetingFunc函数，传入不同的msg，并创建不同的函数返回
    // 然而，msg只是一个局部变量，却在getGreetingFunc执行完之后，还可以继续存在创建的函数之中；greetingFuncHello("leo")，调用时，值为"hello"的msg被保留在了函数体内部，可以反复的使用
    // 这种变量超出了其作用域，还可以使用的情况，即为闭包

    // Scala通过为每个函数创建对象来实现闭包，实际上对于getGreetingFunc函数创建的函数，msg是作为函数对象的变量存在的，因此每个函数才可以拥有不同的msg

    // Scala编译器会确保上述闭包机制

    val greetingFuncHello = getGreetingFunc("hello")
    greetingFuncHello("leo")
    val greetingFuncHi = getGreetingFunc("Hi")
    greetingFuncHi("leo")
  }

  def getGreetingFunc(msg: String) = (name: String) => println(msg + "," + name)
}