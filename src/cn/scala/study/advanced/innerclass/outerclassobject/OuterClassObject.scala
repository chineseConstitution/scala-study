package cn.scala.study.advanced.innerclass.outerclassobject

import scala.collection.mutable.ArrayBuffer
/**
 * 一、内部类的作用域：外部类对象
 *
 */
object OuterClassObject {
  def main(args: Array[String]): Unit = {

    val c1 = new Class
    val leo = c1.register("leo")
    c1.students += leo

    val c2 = new Class
    val jack = c2.register("jack")
    //报错 type mismatch; found : c2.Student required: c1.Student
    //c1.students += jack

  }
}

class Class {
  class Student(val name: String)
  val students = new ArrayBuffer[Student]
  def register(name: String) = {
    new Student(name)
  }
}
