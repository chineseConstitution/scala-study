package cn.scala.study.objects.traits.specificandabstract

/**
 * // 2-4 混合使用trait的具体方法和抽象方法
 * // 在trait中，可以混合使用具体方法和抽象方法
 * // 可以让具体方法依赖于抽象方法，而抽象方法则放到继承trait的类中去实现
 * // 这种trait其实就是设计模式中的模板设计模式的体现
 * 
 */
object MixedMethod {
  def main(args: Array[String]): Unit = {
    //val p = new Person("johnny") //false
		  val p = new Person("leo") //true
  }
}