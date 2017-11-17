package cn.scala.study.main

import java.io.IOException
import java.io.IOException

/**
 * 函数入门之异常
 */
object FunctionTest5 {
  def main(args: Array[String]): Unit = {
    try {
      throw new IllegalArgumentException("x should not be negative")
    } catch {
      case _: IllegalArgumentException => println("Illegal Argument!")
    } finally {
      println("release resources!\n")
    }

    try {
      throw new IOException("user defined exception")
    } catch {
      case e1: IllegalArgumentException => println(e1 + "illegal argument")
      case e2: IOException              => println( e2 + "io exception")
    }

  }
}