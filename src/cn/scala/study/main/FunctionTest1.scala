package cn.scala.study.main

/**
 * 函数入门
 */
object FunctionTest1 {
  def main(args: Array[String]): Unit = {
    sayHello("leo", 30)
    sayHello("jack")
    println(sum(10))
    println(fab(10))
  }

  //1、在Scala中定义函数时，需要定义函数的函数名、参数、函数体。
  //Scala要求必须给出所有参数的类型，但是不一定给出函数返回值的类型。
  //只要右侧的函数体中不包含递归的语句，Scala就可以自己根据右侧的表达式推断出返回类型。
  def sayHello(name: String, age: Int) = {
    if (age > 18) { printf("hi %s, you are a big boy\n", name); age }
    else { printf("hi %s, you are a little boy\n", name); age }
  }

  //2、单行的函数
  def sayHello(name: String) = println("Hello," + name)

  /**
   * 如果函数体中有多行代码，则可以使用代码块的方式包裹多行代码，代码块中最后一行的返回值就是整个函数的返回值。
   * 与Java中不同，不是使用return返回值的。
   * 比如如下的函数，实现累加的功能：
   *
   */
  //3、实现累加
  def sum(n: Int) = {
    var sum = 0
    for (i <- 1 to n) sum += i
    sum
  }

  /**
   * 如果在函数体内递归调用函数自身，则必须手动给出函数的返回类型。
   * 例如，实现经典的斐波那契数列：
   */
  //4、递归函数与返回类型：实现斐波那契数列
  def fab(n: Int): Int = {
    if (n <= 1) 1
    else fab(n - 1) + fab(n - 2)
  }
}