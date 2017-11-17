package cn.scala.study.objects.constructors

// Scala中，每个类可以有一个主constructor和任意多个辅助constructor，
// 而每个辅助constructor的第一行都必须是调用其他辅助constructor或者是主constructor；因此子类的辅助constructor是一定不可能直接调用父类的constructor的
// 只能在子类的主constructor中调用父类的constructor，以下这种语法，就是通过子类的主构造函数来调用父类的构造函数
// 注意！如果是父类中接收的参数，比如name和age，子类中接收时，就不要用任何val或var来修饰了，否则会认为是子类要覆盖父类的field
class Student(name:String, age:Int, var score:Double) extends Person(name, age){
  def this(name:String){
    this(name,0,0.0)
  }
  
  def this(age:Int){
    this("leo",age,0)
  }
}