package cn.scala.study.objects.objects

// object的功能其实和class类似，除了不能定义接受参数的constructor之外
// object也可以继承抽象类，并覆盖抽象类中的方法
abstract class Hello(var message:String) {
  def sayHello(name:String):Unit
}
