package cn.scala.study.main

import scala.collection.mutable.ArrayBuffer

/**
 * 数组操作之数组转换
 * 使用yield和函数式编程转换数组
 * 
 */
object ArrayTest2 {
  def main(args: Array[String]): Unit = {
    // 对Array进行转换，获取的还是Array
    val a = Array(1,2,3,4,5)
    val a2 = for(ele <- a) yield ele * ele
    for(i <- a2) println(i)
    
    // 对ArrayBuffer进行转换，获取的还是ArrayBuffer
    val b = ArrayBuffer[Int]()
    b += (1,2,3,4,5)
    val b2 = for(ele <- b) yield ele * ele
    // 结合if守卫，仅转换需要的元素
    val a3 = for(ele <- b if ele % 2 == 0) yield ele * ele
    for(i <- a3) println(i)
    
    // 使用函数式编程转换数组（通常使用第一种方式）
    a.filter (_%2==0).map(2*_)
    a.filter {  _% 2 == 0 }.map { 2 * _ }
  }
}