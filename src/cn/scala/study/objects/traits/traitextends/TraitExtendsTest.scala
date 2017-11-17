package cn.scala.study.objects.traits.traitextends

/**
 * // 2-7 让trait继承类
 * // 在Scala中，trait也可以继承自class，此时这个class就会成为所有继承该trait的类的父类
 */
object TraitExtendsTest {
  def main(args: Array[String]): Unit = {
    val p = new Person("leo")
    p.sayHello
  }
}