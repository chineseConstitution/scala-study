package cn.scala.study.typeparameter.covarianceandinverter

object CovarianceAndInverter {
  def main(args: Array[String]): Unit = {
    // Scala的协变和逆变是非常有特色的！完全解决了Java中的泛型的一大缺憾！
    // 举例来说，Java中，如果有Professional是Master的子类，那么Card[Professionnal]是不是Card[Master]的子类？答案是：不是。因此对于开发程序造成了很多的麻烦。
    // 而Scala中，只要灵活使用协变和逆变，就可以解决Java泛型的问题。

    //案例：进入会场
    val m1 = new Master
    val p1 = new Professional
    enterMeet(new Card[Master]("leo"))
    enterMeet(new Card[Professional]("leo"))
    //enterMeet(new Card[Person]("leo"))

  }

  //    // 协变：案例：进入会场
  //    def enterMeet(card:Card[Professional]){
  //      println("welcome to have this meeting")
  //    }

  //逆变：案例：进入会场
  def enterMeet(card: Card[Professional]) {
    println("welcome to have this meeting!")
  }

}

class Master
class Professional extends Master
class Person

//// 协变：大师以及大师级别以下的名片都可以进入会场
//class Card[+T](val name: String)

// 逆变：只要专家级别的名片就可以进入会场，如果大师级别的过来了，当然可以了！
class Card[-T](val name: String)
