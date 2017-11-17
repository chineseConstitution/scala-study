package cn.scala.study.implicits

object mainTest {
  def main(args: Array[String]): Unit = {
    // Scala提供的隐式转换和隐式参数功能，是非常有特色的功能。
    // 是Java等编程语言所没有的功能。它可以允许你手动指定，将某种类型的对象转换成其他类型的对象。
    // 通过这些功能，可以实现非常强大，而且特殊的功能。
    // Scala的隐式转换，其实最核心的就是定义隐式转换函数，即implicit conversion function。
    // 定义的隐式转换函数，只要在编写的程序内引入，就会被Scala自动使用。
    // Scala会根据隐式转换函数的签名，在程序中使用到隐式转换函数接收的参数类型定义的对象时，会自动将其传入隐式转换函数，转换为另外一种类型的对象并返回。这就是“隐式转换”。
    // 隐式转换函数叫什么名字是无所谓的，因为通常不会由用户手动调用，而是由Scala进行调用。但是如果要使用隐式转换，则需要对隐式转换函数进行导入。因此通常建议将隐式转换函数的名称命名为“one2one”的形式。
    // Spark源码中有大量的隐式转换和隐式参数，因此必须精通这种语法。

    //隐式转换大纲
    //1、隐式转换（案例：特殊售票窗口）
    //2、使用隐式转换加强现有类型（案例：超人变身）
    //3、隐式转换函数的作用域与导入
    //4、隐式转换的发生时机（案例：特殊售票窗口加强版）
    //5、隐式参数（案例：考试签到）

    // Scala默认会使用两种隐式转换，一种是源类型，或者目标类型的伴生对象内的隐式转换函数；
    // 一种是当前程序作用域内的可以用唯一标识符表示的隐式转换函数。

    // 如果隐式转换函数不在上述两种情况下的话，那么就必须手动使用import语法引入某个包下的隐式转换函数，
    // 比如import test._。通常建议，仅仅在需要进行隐式转换的地方，比如某个函数或者方法内，用import导入隐式转换函数，这样可以缩小隐式转换函数的作用域，避免不需要的隐式转换。

  }
}