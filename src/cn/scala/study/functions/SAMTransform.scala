package cn.scala.study.functions

import javax.swing._
import java.awt.event._

object SAMTransform {
  def main(args: Array[String]): Unit = {
    val button = new JButton("Click")
    button.addActionListener(new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        println("Click Me!!!")
      }
    })

    // 7、SAM转换
    // 在Java中，不支持直接将函数传入一个方法作为参数，
    // 通常来说，唯一的办法就是定义一个实现了某个接口的类的实例对象，该对象只有一个方法；
    // 而这些接口都只有单个的抽象方法，也就是single abstract method，简称为SAM
    // 由于Scala是可以调用Java的代码的，因此当我们调用Java的某个方法时，可能就不得不创建SAM传递给方法，非常麻烦；
    // 但是Scala又是支持直接传递函数的。
    // 此时就可以使用Scala提供的，在调用Java方法时，使用的功能，SAM转换，即将SAM转换为Scala函数
    // 要使用SAM转换，需要使用Scala提供的特性，隐式转换
    implicit def getActionListener(actionProcessFunc: (ActionEvent) => Unit) = new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        actionProcessFunc(event)
      }
    }

    button.addActionListener((event: ActionEvent) => println("Click Me!!!"))
  }
}