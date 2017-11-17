package cn.scala.study.objects.extend

class Student extends Person {
  private var score = "A"
  def getScore = score
  // Scala中，如果子类要覆盖一个父类中的非抽象方法，则必须使用override关键字
  // override关键字可以帮助我们尽早地发现代码里的错误，比如：override修饰的父类方法的方法名我们拼写错了；比如要覆盖的父类方法的参数我们写错了；等等
  // 此外，在子类覆盖父类方法之后，如果我们在子类中就是要调用父类的被覆盖的方法呢？那就可以使用super关键字，显式地指定要调用父类的方法
  override def getName = "Hi, I'm" + super.getName
}


//// Scala中，子类可以覆盖父类的val field，而且子类的val field还可以覆盖父类的val field的getter方法；只要在子类中使用override关键字即可
//
//class Person {
//  val name: String = "Person"
//  def age: Int = 0
//}
//
//class Student extends Person {
//  override val name: String = "leo"
//  override val age: Int = 30
//}


//// 跟java一样，scala中同样可以使用protected关键字来修饰field和method，这样在子类中就不需要super关键字，直接就可以访问field和method
//// 还可以使用protected[this]，则只能在当前子类对象中访问父类的field和method，无法通过其他子类对象访问父类的field和method（同private[this]类似）
//class Person {
//  protected var name: String = "leo"
//  protected[this] var hobby: String = "game"
//} 
//class Student extends Person {
//  def sayHello = println("Hello, " + name)
//  def makeFriends(s: Student) {
//    println("my hobby is " + hobby + ", your hobby is " + s.hobby)
//  }
//}

