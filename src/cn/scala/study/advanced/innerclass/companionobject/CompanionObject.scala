package cn.scala.study.advanced.innerclass.companionobject

import scala.collection.mutable.ArrayBuffer

/**
 * 二、扩大内部类作用域：伴生对象
 *
 */
object CompanionObject {
  def main(args: Array[String]): Unit = {
    val c1 = new Class
    val leo = c1.register("leo")
    c1.students += leo

    val c2 = new Class
    val jack = c2.register("jack")
    c1.students += jack

  }
}

object Class {
  class Student(val name: String)
}

class Class {
  val students = new ArrayBuffer[Class.Student]
  def register(name: String) = {
    new Class.Student(name)
  }
}
