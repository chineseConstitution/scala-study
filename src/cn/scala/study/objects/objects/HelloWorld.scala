package cn.scala.study.objects.objects

// 就如同java中，如果要运行一个程序，必须编写一个包含main方法类一样；在scala中，如果要运行一个应用程序，那么必须有一个main方法，作为入口
// scala中的main方法定义为def main(args: Array[String])，而且必须定义在object中
/**
 * 在cmd窗口下进入指定目录：
 * 执行编译命令：scalac HelloWorld.scala
 * 编译完后得到class文件
 * 然后执行：scala HelloWorld
 * HelloWorld!
 * // 如果要运行上述代码，需要将其放入.scala文件，然后先使用scalac编译，再用scala执行
 * scalac HelloWorld.scala
 * scala -Dscala.time HelloWorld
 * 可以同时显示运行花了多长时间
 * // App Trait的工作原理为：App Trait继承自DelayedInit Trait，scalac命令进行编译时，
 * 会把继承App Trait的object的constructor代码都放到DelayedInit Trait的delayedInit方法中执行
 */
//object HelloWorld {
//  def main(args: Array[String]): Unit = {
//    println("Hello World!")
//  }
//}

// 除了自己实现main方法之外，还可以继承App Trait，然后将需要在main方法中运行的代码，直接作为object的constructor代码；而且用args可以接受传入的参数
object HelloWorld extends App {
  if (args.length > 0) println("hello, " + args(0))
  else println("Hello World!!!")
}
