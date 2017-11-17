package cn.scala.study.advanced.innerclass.inneroutter

/**
 * 四、内部类获取外部类的引用
 *
 */
object InnerOutter {
  def main(args: Array[String]): Unit = {
    val c1 = new Class("c1")
    val leo = c1.register("leo")
    println(leo.introduceMyself)

  }
}

class Class(val name: String) { outer =>
  class Student(val name: String) {
    def introduceMyself = "Hello, I'm " + name + ", I'm very happy to join class " + outer.name
  }
  def register(name: String) = {
    new Student(name)
  }
}
