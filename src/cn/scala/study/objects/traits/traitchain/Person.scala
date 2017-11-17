package cn.scala.study.objects.traits.traitchain

class Person(val name:String) extends SigntureValidHandler with DataValidHandler {
  def sayHello = {println("Hello," + name); handle(name)}
}