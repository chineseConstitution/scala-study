package cn.scala.study.objects.traits.traitconstructor

class Student extends Person with MyLogger with TimeLogger{
  println("Student's constructor!")
}