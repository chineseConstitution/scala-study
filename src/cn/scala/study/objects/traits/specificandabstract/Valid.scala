package cn.scala.study.objects.traits.specificandabstract

trait Valid {
  def getName:String
  def valid:Boolean={
    getName == "leo"
  }
}