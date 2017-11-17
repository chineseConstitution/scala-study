package cn.scala.study.objects.traits

/**
 * // 1-1 将trait作为接口使用
 * // Scala中的Triat是一种特殊的概念
 * // 首先我们可以将Trait作为接口来使用，此时的Triat就与Java中的接口非常类似
 * // 在triat中可以定义抽象方法，就与抽象类中的抽象方法一样，只要不给出方法的具体实现即可
 * // 类可以使用extends关键字继承trait，注意，这里不是implement，而是extends，在scala中没有implement的概念，无论继承类还是trait，统一都是extends
 * // 类继承trait后，必须实现其中的抽象方法，实现时不需要使用override关键字
 * // scala不支持对类进行多继承，但是支持多重继承trait，使用with关键字即可
 */
class Person(val name: String) extends Logger with HelloTrait with MakeFriendsTrait with Cloneable with Serializable {
  val msg: String = "hello"
  def makeFriends(p: Person) {
    println("Hello,my name is " + name + ",your name is " + p.name)

    // 1-2 在trait中定义具体方法
    // Scala中的Triat可以不是只定义抽象方法，还可以定义具体方法，此时trait更像是包含了通用工具方法的东西
    // 有一个专有的名词来形容这种情况，就是说trait的功能混入了类
    // 举例来说，trait中可以包含一些很多类都通用的功能方法，比如打印日志等等，spark中就使用了trait来定义了通用的日志打印方法
    log("makeFriends method is invoked with parameter Person[name=" + p.name + "]")
  }
  def sayHello(name: String) = println("Hello," + name + ",I'm " + this.name)
}

//// 1-3 在trait中定义具体字段
//// Scala中的Triat可以定义具体field，此时继承trait的类就自动获得了trait中定义的field
//// 但是这种获取field的方式与继承class是不同的：如果是继承class获取的field，实际是定义在父类中的；而继承trait获取的field，就直接被添加到了类中
//
//trait Person {
//  val eyeNum: Int = 2
//}
//
//class Student(val name: String) extends Person {
//  def sayHello = println("Hi, I'm " + name + ", I have " + eyeNum + " eyes.")
//}
//val s = new Student(“leo”)
//s.sayHello
//Hi, I’m leo,I have 3 eyes.

// Scala中的Triat可以定义抽象field，而trait中的具体方法则可以基于抽象field来编写
// 但是继承trait的类，则必须覆盖抽象field，提供具体的值

////1-4 在trait中定义抽象字段
//// Scala中的Triat可以定义抽象field，而trait中的具体方法则可以基于抽象field来编写
//// 但是继承trait的类，则必须覆盖抽象field，提供具体的值
//trait SayHello {
//  val msg: String
//  def sayHello(name: String) = println(msg + ", " + name)
//}
//
//class Person(val name: String) extends SayHello {
//  val msg: String = "hello"
//  def makeFriends(p: Person) {
//    sayHello(p.name)
//    println("I'm " + name + ", I want to make friends with you!")
//  }
//}

//scala> val p1 = new Person("leo")
//p1: Person = Person@568653d9
//
//scala> val p2 = new Person("jack")
//p2: Person = Person@2f3409c5
//
//scala> p1.makeFriends(p2)
//hello, jack
//I'm leo, I want to make friends with you!

//// 2-1 为实例对象混入trait
//// 有时我们可以在创建类的对象时，指定该对象混入某个trait，这样，就只有这个对象混入该trait的方法，而类的其他对象则没有
//class Person(val name: String) extends Logged {
//    def sayHello { println("Hi, I'm " + name); log("sayHello is invoked!") }
//}
//val p2 = new Person("jack") with MyLogger
//中mylogger会覆盖掉logged中的方法

