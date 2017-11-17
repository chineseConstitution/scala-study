package cn.scala.study.typeparameter.lowerupperbounds

object LowerBounds {
  def main(args: Array[String]): Unit = {
    // 除了指定泛型类型的上边界，还可以指定下边界，即指定泛型类型必须是某个类的父类

    //4、下边界Bounds（案例：领身份证）
    val f1 = new Father("jack")
    val s1 = new Child("leo")
    getIDCard(f1)
    getIDCard(s1)
  }

  //案例：领身份证
  def getIDCard[R >: Child](person: R) {
    if (person.getClass == classOf[Child]) println("please tell us your parents's names.")
    else if(person.getClass() == classOf[Father]) println("sign your name for your child's id card.")
    else println("sorry,you are not allowed to get id card.")
  }

}

class Father(val name: String)

class Child(name: String) extends Father(name)



