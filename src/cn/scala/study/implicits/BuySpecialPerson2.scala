package cn.scala.study.implicits

object BuySpecialPerson2 {
  def main(args: Array[String]): Unit = {
    // 1、调用某个函数，但是给函数传入的参数的类型，与函数定义的接收参数类型不匹配（案例：特殊售票窗口）
    // 2、使用某个类型的对象，调用某个方法，而这个方法并不存在于该类型时（案例：超人变身）
    // 3、使用某个类型的对象，调用某个方法，虽然该类型有这个方法，但是给方法传入的参数类型，与方法定义的接收参数的类型不匹配（案例：特殊售票窗口加强版）

    //4、隐式转换的发生时机（案例：特殊售票窗口加强版）
    val ticketHouse = new TicketHouse
    val leo = new Student("leo")
    ticketHouse.buySpecialTicket(leo)
  }
  
    // 案例：特殊售票窗口（只接受特殊人群，比如学生、老人等）
  implicit def object2SpecialPerson(obj: Object): SpecialPerson = {
    if (obj.getClass == classOf[Student]) {
      val stu = obj.asInstanceOf[Student]
      new SpecialPerson(stu.name)
    } else if (obj.getClass == classOf[Older]) {
      val older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    } else Nil
  }
  
  // 案例：特殊售票窗口加强版
  class TicketHouse{
    var ticketNumber = 0
    def buySpecialTicket(p:SpecialPerson) = {
      ticketNumber += 1
      "T-" + ticketNumber
      println("T-" + ticketNumber)
    }
  }
}
