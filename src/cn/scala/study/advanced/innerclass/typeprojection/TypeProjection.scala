package cn.scala.study.advanced.innerclass.typeprojection

import scala.collection.mutable.ArrayBuffer

/**
 * 三、扩大内部类作用域：类型投影
 *
 */
object TypeProjection {
  def main(args: Array[String]): Unit = {
    val c1 = new Class
    val leo = c1.register("leo")
    c1.students += leo

    val c2 = new Class
    val jack = c2.register("jack")
    c1.students += jack

  }
}

class Class {
  class Student(val name: String)
  val students = new ArrayBuffer[Class#Student]
  def register(name: String) = {
    new Student(name)
  }
}
