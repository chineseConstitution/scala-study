package cn.scala.study.objects.traits.traitextends

class Person(val name:String) extends Logger {
  def sayHello{
    log("Hi, I'm " + name)
    printMessage("Hi, I'm " + name)
  }
}