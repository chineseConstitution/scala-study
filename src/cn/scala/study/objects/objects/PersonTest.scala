package cn.scala.study.objects.objects

object PersonTest {
  def main(args: Array[String]): Unit = {
    Person.getEyeNum
    println(Person.getEyeNum)
    
    val p = new Person("leo", 78)
    p.sayHello
    
    /**
     * // object中非常重要的一个特殊方法，就是apply方法
		 * // 通常在伴生对象中实现apply方法，并在其中实现构造伴生类的对象的功能
     * // 而创建伴生类的对象时，通常不会使用new Class的方式，而是使用Class()的方式，隐式地调用伴生对象得apply方法，
     * // 这样会让对象创建更加简洁
     * // 比如，Array类的伴生对象的apply方法就实现了接收可变数量的参数，并创建一个Array对象的功能
     *  val a = Array(1, 2, 3, 4, 5)
     * // 比如，定义自己的伴生类和伴生对象
     * class Person(val name: String)
     * object Person {
     *   def apply(name: String) = new Person(name)
     * }
     * 
     */
    //第二个Person(“leo”)就隐式的调用了伴生对象中的apply函数，利用new Person(name)中创建对象。
    //在spark中基本都使用第二种方式创建对象。
    val p1 = Person("kobe", 45)
    p1.sayHello
    
    println(Season.SPRING)
    println(Season.SPRING.id)
    println(Season.SPRING.toString())
    println(Season(0))
    println(Season(2))
    println(Season.withName("spring"))
    
    // 使用枚举object.values可以遍历枚举值
    for (ele <- Season.values) println(" " + ele)
  }
}