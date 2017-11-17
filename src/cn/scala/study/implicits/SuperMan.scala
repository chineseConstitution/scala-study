package cn.scala.study.implicits

object SuperMan {
  def main(args: Array[String]): Unit = {
    // 隐式转换非常强大的一个功能，就是可以在不知不觉中加强现有类型的功能。
    // 也就是说，可以为某个类定义一个加强版的类，并定义互相之间的隐式转换，从而让源类在使用加强版的方法时，由Scala自动进行隐式转换为加强类，然后再调用该方法。

    //2、使用隐式转换加强现有类型（案例：超人变身）
    val leo = new Man("leo")
    leo.emitLaser

  }

  // 隐式转换非常强大的一个功能，就是可以在不知不觉中加强现有类型的功能。也就是说，可以为某个类定义一个加强版的类，并定义互相之间的隐式转换，从而让源类在使用加强版的方法时，由Scala自动进行隐式转换为加强类，然后再调用该方法。
  implicit def man2superman(man: Man): Superman = new Superman(man.name)

  // 案例：超人变身
  class Man(val name: String)
  class Superman(val name: String) {
    def emitLaser = println("emit a laster!")
  }

}


