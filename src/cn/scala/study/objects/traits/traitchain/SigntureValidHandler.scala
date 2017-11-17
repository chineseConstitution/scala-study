package cn.scala.study.objects.traits.traitchain

trait SigntureValidHandler extends Handler {
  override def handle(data:String){
    println("check signture:" + data)
    super.handle(data)
  }
}