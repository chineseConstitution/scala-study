package cn.scala.study.objects.traits

/**
 * 1、trait基础知识
 *  1-1 将trait作为接口使用
 *  1-2 在trait中定义具体方法
 *  1-3 在trait中定义具体字段
 *  1-4 在trait中定义抽象字段
 * 2、trait高级知识
 *  2-1 为实例对象混入trait
 *  2-2 trait调用链
 *  2-3 在trait中覆盖抽象方法
 *  2-4 混合使用trait的具体方法和抽象方法
 *  2-5 trait的构造机制
 *  2-6 trait字段的初始化
 *  2-7 让trait继承类
 */
object Test {
  def main(args: Array[String]): Unit = {
    val p = new Person("leo")
    p.sayHello("jack")
    val p2 = new Person("jack")
    p.makeFriends(p2)
  }
}
