package cn.scala.study.objects.objects

// object，相当于class的单个实例，通常在里面放一些静态的field或者method
// 第一次调用object的方法时，就会执行object的constructor，也就是object内部不在method中的代码；但是object不能定义接受参数的constructor
// 注意，object的constructor只会在其第一次被调用时执行一次，以后再次调用就不会再次执行constructor了
// object通常用于作为单例模式的实现，或者放class的静态成员，比如工具方法

/**
 * 之前的class通常是这样定义的：
 * class Person { var name:String = "" val age:Int = 0 private var address:String = "" private[this] var hobby:String = "" }
 * 在scala中没有提供static的成员，没有提供静态成员，在class中无法定义所有的实例对象共享的东西。
 * 这种静态的成员只能定义在object中。
 */
object Person {
  private var eyeNum = 2;
  println("this Person object!")
  def getEyeNum = eyeNum

  // object中非常重要的一个特殊方法，就是apply方法
  // 通常在伴生对象中实现apply方法，并在其中实现构造伴生类的对象的功能
  // 而创建伴生类的对象时，通常不会使用new Class的方式，而是使用Class()的方式，隐式地调用伴生对象得apply方法，这样会让对象创建更加简洁
  def apply(name: String, age: Int) = new Person(name, age)
}

// 如果有一个class，还有一个与class同名的object，那么就称这个object是class的伴生对象，class是object的伴生类
// 伴生类和伴生对象必须存放在一个.scala文件之中
// 伴生类和伴生对象，最大的特点就在于，互相可以访问private field
class Person(val name: String, val age: Int) {
  def sayHello = println("Hi, " + name + ", I guess you are " + age + " years old!" + ", and usually you must have " + Person.eyeNum + " eyes.")
}
