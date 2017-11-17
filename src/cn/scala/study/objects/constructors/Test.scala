package cn.scala.study.objects.constructors

// Scala中，每个类可以有一个主constructor和任意多个辅助constructor，而每个辅助constructor的第一行都必须是调用其他辅助constructor或者是主constructor；因此子类的辅助constructor是一定不可能直接调用父类的constructor的
// 只能在子类的主constructor中调用父类的constructor，以下这种语法，就是通过子类的主构造函数来调用父类的构造函数
// 注意！如果是父类中接收的参数，比如name和age，子类中接收时，就不要用任何val或var来修饰了，否则会认为是子类要覆盖父类的field
object Test {
  def main(args: Array[String]): Unit = {
    val s = new Student("leo", 30, 100)
    val s1 = new Student("leo")
    s1.name = "kebo"
    s1.age = 19
    s1.score = 0.0
    val s2 = new Student(20)
    s2.name = "wade"
    s2.age = 20
    s2.score = 0.0
  }
}