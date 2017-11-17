package cn.scala.study.objects.innerclass

// Scala中，同样可以在类中定义内部类；但是与java不同的是，每个外部类的对象的内部类，都是不同的类
import scala.collection.mutable.ArrayBuffer
class Class {
  class Student(val name: String) {}
  val students = new ArrayBuffer[Student]
  def getStudent(name: String) = {
    new Student(name)
  }
}

object Class {
  def main(args: Array[String]): Unit = {
    val c1 = new Class
    val s1 = c1.getStudent("leo1")
    c1.students += s1
    val s2 = c1.getStudent("leo2")
    //添加正常
    c1.students += s2
    for(e <- c1.students)
      println(e.name)
    //    val c2 = new Class
    //    val s2 = c2.getStudent("leo3")
    //    //添加出错
    //    c1.students += s2
  }
}