package cn.scala.study.main

import scala.collection.mutable.ArrayBuffer

object ArrayCase {
  def main(args: Array[String]): Unit = {
    //构建数组
    val a = ArrayBuffer[Int]()
    a += (1,2,3,4,5,-1,-3,-5,-9)
    
//    removeNegativeNum1(a)
    removeNegativeNum2(a)
  }
  
  /**
   * 移除第一个负数之后的所有负数
   * 每发现一个第一个负数之后的负数，就进行移除，性能较差，多次移动数组
   */
  def removeNegativeNum1(a:ArrayBuffer[Int]){
    var foundFirstNegative = false
    var arrayLength = a.length
    var index = 0
    while(index < arrayLength){
      if(a(index) >= 0){
        //如果当前数为正数，则继续遍历
        index += 1
      }else{
        if (!foundFirstNegative) {
          //如果当前数为负数且标志的flag仍然为false，则改变flag为true，继续遍历
          foundFirstNegative = true
          index += 1
        }else{
          //如果当前数为负数且标志的flag已经为true，则将次数移除，并数组长度减去一
          a.remove(index);arrayLength -= 1
        }
      }
    }
    //打印数组
    for(ele <- a) println(ele)
  }

  /**
   * 每记录所有不需要移除的元素的索引，
   * 稍后一次性移除所有需要移除的元素性能较高，数组内的元素迁移只要执行一次即可
   */
  def removeNegativeNum2(a: ArrayBuffer[Int]){
    var foundFirstNegative = false;
    //当foundFirstNegative为false或者a(i)大于0的时候执行yield
    val keepIndexes = for(i <- 0 until a.length if !foundFirstNegative || a(i) >= 0) yield{
      if(a(i) < 0)foundFirstNegative = true
      i
    }
    
    // keepIndexes 的值为(1,2,3,4,5,6),执行此句后a值为: (1, 2, 3, 4, 5, -1)
    for(i <- 0 until keepIndexes.length) {
      a(i) = a(keepIndexes(i))
    }
    
    //取出a后面多余的数
    a.trimEnd(a.length - keepIndexes.length)
    //打印数组
    for(ele <- a) println(ele)
  }
}