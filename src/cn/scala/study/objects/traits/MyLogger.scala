package cn.scala.study.objects.traits

trait MyLogger extends Logged{
  override def log(msg:String){println("log:" + msg)}
}