package cn.scala.study.implicits

object ImplicitParameter {
  def main(args: Array[String]): Unit = {
    // 所谓的隐式参数，指的是在函数或者方法中，定义一个用implicit修饰的参数。
    // 此时Scala会尝试找到一个指定类型的，用implicit修饰的对象，即隐式值，并注入参数。
    // Scala会在两个范围内查找：一种是当前作用域内可见的val或var定义的隐式变量；一种是隐式参数类型的伴生对象内的隐式值。

    signForExam("leo")
  }

  class SignPen {
    def write(content: String) = println(content)
  }

  implicit val signPen = new SignPen
  
  // 案例：考试签到
  def signForExam(name: String)(implicit signPen: SignPen) {
    signPen.write(name + " come to exam in time.")
  }
}