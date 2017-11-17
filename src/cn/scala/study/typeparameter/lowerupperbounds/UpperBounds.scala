package cn.scala.study.typeparameter.lowerupperbounds

object UpperBounds {
  def main(args: Array[String]): Unit = {
    // 在指定泛型类型的时候，有时，我们需要对泛型类型的范围进行界定，而不是可以是任意的类型。
    // 比如，我们可能要求某个泛型类型，它就必须是某个类的子类，
    // 这样在程序中就可以放心地调用泛型类型继承的父类的方法，程序才能正常的使用和运行。
    // 此时就可以使用上下边界Bounds的特性。
    // Scala的上下边界特性允许泛型类型必须是某个类的子类，或者必须是某个类的父类

    //Scala的上边界特性允许泛型类型必须是某个类的子类
    //3、上边界Bounds（案例：在派对上交朋友）
    val leo = new Student("leo")
    val tom = new Worker("tom")
    //tom不
    //val party = new Party(leo, tom)
    val jack = new Student("jack")
    val party = new Party(leo, jack)
    party.play

  }
}

//在派对上交朋友
class Person(val name: String) {
  def sayHello = println("Hello,I'm " + name)
  def makeFriends(p: Person) {
    sayHello
    p.sayHello
  }
}

class Student(name: String) extends Person(name)

class Worker(val name: String)

class Party[T <: Person](p1: T, p2: T) {
  def play = p1.makeFriends(p2)
}