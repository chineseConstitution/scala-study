package cn.scala.study.objects

/**
 * 课程大纲
 * 1、定义一个简单的类
 * 2、field的getter与setter详解
 * 3、constructor详解
 * 4、内部类介绍
 */
object HelloWorldTest {
  def main(args: Array[String]): Unit = {
    //    // 创建类的对象，并调用其方法
    //    val helloWorld = new HelloWorld
    //    // 也可以不加括号
    //    helloWorld.sayHello()
    //    // 也可以不加括号，如果定义方法时不带括号，则调用方法时也不能带括号
    //    println(helloWorld.getName)
    //
    //    val leo = new Student
    //    println(leo.name)
    //    leo.name = "leo1"
    //    println(leo.name)
    //
    //    println(leo.name)
    //    leo.ownname_=("leo1")
    //    println(leo.oname)
    //
    //    val s1 = new Student
    //    val s2 = new Student
    //    
    //    s1.age = 20
    //    s2.age = 30
    //    val flag = s2.older(s1)
    //    println(flag)

        //java风格的getter和setter
        val s = new Student
        s.setName("leo")
        println(s.getName())

    //    //class Student(@BeanProperty var name: String)
    //    val s2 = new Student("leo")
    //    s.getName
    //    s.setName("jacl")
    //    s.getName

  }
}