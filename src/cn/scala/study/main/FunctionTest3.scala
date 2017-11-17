package cn.scala.study.main

/**
 * 函数入门值变长参数
 */
object FunctionTest3 {
  def main(args: Array[String]): Unit = {
    println(sum(1,2,3,4,5))
    /**
     * 在如果想要将一个已有的序列直接调用变长参数函数，是不对的。
     * 比如val s = sum(1 to 5)。
     * 此时需要使用Scala特殊的语法将参数定义为序列，让Scala解释器能够识别。
     * 这种语法非常有用！一定要好好主意，在spark的源码中大量地使用到了。
     */
    println(sum2(1 to 5: _*))
  }
  
  /*
   * 在Scala中，有时我们需要将函数定义为参数个数可变的形式，则此时可以使用变长参数定义函数。
   */
  def sum(nums:Int*) = {
    var res = 0
    for(num <- nums) res += num
    res
  }
  
  def sum2(nums:Int*):Int = {
    if(nums.length == 0) 0
    else nums.head + sum2(nums.tail:_*)
  }
}