package cn.scala.study.objects.traits.traitinit

object FieldInitTest {
  def main(args: Array[String]): Unit = {
    /**
     * // 2-6 trait字段的初始化 
     * // 在Scala中，trait是没有接收参数的构造函数的，这是trait与class的唯一区别，
     * // 但是如果需求就是要trait能够对field进行初始化，该怎么办呢？
     * // 只能使用Scala中非常特殊的一种高级特性——提前定义
     */
    ////此创建方法对应方法一定义对象的方式
    //    val p = new {
    //      val msg:String = "init"
    //    } with Person with SayHello
    
    //此创建方法对应方法二定义对象的方式
    val p = new Person
  }
}


//// 另外一种方式就是使用lazy value
//trait SayHello {
//  lazy val msg: String = null
//  println(msg.toString)
//}
//class Person extends SayHello {
//  override lazy val msg: String = "init"
//}
