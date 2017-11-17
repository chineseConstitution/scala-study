package cn.scala.study.objects.traits.traitconstructor

/**
 * // 2-5 trait的构造机制
 * // 在Scala中，trait也是有构造代码的，也就是trait中的，不包含在任何方法中的代码
 * // 而继承了trait的类的构造机制如下：1、父类的构造函数执行；2、trait的构造代码执行，多个trait从左到右依次执行；3、构造trait时会先构造父trait，如果多个trait继承同一个父trait，则父trait只会构造一次；4、所有trait构造完毕之后，子类的构造函数执行
 * // Trait也是有构造函数的，与class相比，它不能定义有参数的构造函数，只有默认的。Trait中不在任何方法内的代码就是trait的构造代码。
 */
object TraitConstructorTest {
  def main(args: Array[String]): Unit = {
    val s = new Student
  }
}