package cn.scala.study.objects.traits.traitextends

trait Logger extends MyUtil{
  def log(msg:String) = printMessage("log: " + msg)
}