package cn.scala.study.objects.abstractclass

// 如果在父类中，有某些方法无法立即实现，而需要依赖不同的子来来覆盖，重写实现自己不同的方法实现。
// 此时可以将父类中的这些方法不给出具体的实现，只有方法签名，这种方法就是抽象方法。
// 而一个类中如果有一个抽象方法，那么类就必须用abstract来声明为抽象类，此时抽象类是不可以实例化的
// 在子类中覆盖抽象类的抽象方法时，不需要使用override关键字
object abstractClassTest {
  def main(args: Array[String]): Unit = {
    //    //class Person is abstract; cannot be instantiated
    //    val p = new Person()
    val s = new Student("wade")
    s.sayHello
  }
}