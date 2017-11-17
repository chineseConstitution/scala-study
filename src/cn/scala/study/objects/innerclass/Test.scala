package cn.scala.study.objects.innerclass

object Test {
  def main(args: Array[String]): Unit = {
    // 在Scala中，匿名子类是非常常见，而且非常强大的。Spark的源码中也大量使用了这种匿名子类。
    // 匿名子类，也就是说，可以定义一个类的没有名称的子类，并直接创建其对象，
    // 然后将对象的引用赋予一个变量。之后甚至可以将该匿名子类的对象传递给其他函数。

    val p = new Person("leo") {
      override def sayHello = "Hi, I'm " + name
    }
    greeting(p);
  }
  def greeting(p: Person { def sayHello: String }) {
    println(p.sayHello)
  }
}