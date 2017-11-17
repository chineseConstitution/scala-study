package cn.scala.study.objects.abstractfield

// 如果在父类中，定义了field，但是没有给出初始值，则此field为抽象field
// 抽象field意味着，scala会根据自己的规则，为var或val类型的field生成对应的getter和setter方法，但是父类中是没有该field的
// 子类必须覆盖field，以定义自己的具体field，并且覆盖抽象field，不需要使用override关键字
abstract class Person {
  val name: String
}

class Student extends Person {
  val name: String = "leo"
}
