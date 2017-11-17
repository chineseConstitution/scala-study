package cn.scala.study.objects.extend

object Test {
  // Scala中，让子类继承父类，与Java一样，也是使用extends关键字
  // 继承就代表，子类可以从父类继承父类的field和method；
  // 然后子类可以在自己内部放入父类所没有，子类特有的field和method；使用继承可以有效复用代码
  // 子类可以覆盖父类的field和method；
  // 但是如果父类用final修饰，field和method用final修饰，则该类是无法被继承的，field和method是无法被覆盖的
  def main(args: Array[String]): Unit = {
    val s = new Student
    println(s.getScore)
    println(s.getName)
    //    //value name is not a member of cn.scala.study.objects.extend.Student
    //    s.name
    //    //value name is not a member of cn.scala.study.objects.extend.Student
    //    s.score

    // 如果我们创建了子类的对象，但是又将其赋予了父类类型的变量。则在后续的程序中，我们又需要将父类类型的变量转换为子类类型的变量，应该如何做？
    // 首先，需要使用isInstanceOf判断对象是否是指定类的对象，如果是的话，则可以使用asInstanceOf将对象转换为指定类型
    // 注意，如果对象是null，则isInstanceOf一定返回false，asInstanceOf一定返回null
    // 注意，如果没有用isInstanceOf先判断对象是否为指定类的实例，就直接用asInstanceOf转换，则可能会抛出异常
    val p: Person = new Student
    var s2: Student = null
    if (p.isInstanceOf[Student]) s2 = p.asInstanceOf[Student]

    // isInstanceOf只能判断出对象是否是指定类以及其子类的对象，而不能精确判断出，对象就是指定类的对象
    // 如果要求精确地判断对象就是指定类的对象，那么就只能使用getClass和classOf了
    // 对象.getClass可以精确获取对象的类，classOf[类]可以精确获取类，然后使用==操作符即可判断
    println(p.isInstanceOf[Person])
    println(p.getClass == classOf[Person])
    println(p.getClass == classOf[Student])

    // 但是在实际开发中，比如spark的源码中，大量的地方都是使用了模式匹配的方式来进行类型的判断，
    // 这种方式更加地简洁明了，而且代码得可维护性和可扩展性也非常的高
    // 使用模式匹配，功能性上来说，与isInstanceOf一样，也是判断主要是该类以及该类的子类的对象即可，不是精准判断的
    p match {
      case per: Person => println("it's Person's object!" + per)
      case _           => println("unknown type")
    }

  }
}