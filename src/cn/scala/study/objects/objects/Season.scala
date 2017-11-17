package cn.scala.study.objects.objects

// Scala没有直接提供类似于Java中的Enum这样的枚举特性，
// 如果要实现枚举，则需要用object继承Enumeration类，并且调用Value方法来初始化枚举值
object Season extends Enumeration {
  //val SPRING,SUMMER,AUTUMN,WINTER = Value
  // 还可以通过Value传入枚举值的id和name，通过id和toString可以获取; 还可以通过id和name来查找枚举值
  val SPRING = Value(0, "spring")
  val SUMMER = Value(1, "summer")
  val AUTUMN = Value(2, "autumn")
  val WINTER = Value(3, "winter")

}