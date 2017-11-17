package cn.scala.study.objects.traits.traitchain

trait DataValidHandler extends Handler {
  override def handle(data:String){
    println("check data:" + data)
    super.handle(data)
  }
}