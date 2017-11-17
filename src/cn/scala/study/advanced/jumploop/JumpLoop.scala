package cn.scala.study.advanced.jumploop

object JumpLoop {
  def main(args: Array[String]): Unit = {
    //1、基于boolean类型的控制变量
    //while循环
    whileFunction()
    //for循环：（高级for循环，加上了if守卫）
    forFunction()
    //2、使用嵌套函数以及return
    val res = add_outer()
    println("在嵌套函数中使用return结果为：" + res)
    //3、使用Breaks类的break方法
    breakFunction()
    println("使用Breaks类的break方法结果为：" + res)
  }

  //while循环
  def whileFunction() {
    var flag = true
    var res = 0
    var n = 0

    while (flag) {
      res += n
      n += 1

      if (n == 5) {
        flag = false
      }
    }
    println("while循环结果为：" + res)

  }

  //for循环：（高级for循环，加上了if守卫）
  def forFunction() {
    var flag = true
    var res = 0

    for (i <- 0 until 10 if flag) {
      res += i
      if (i == 4) flag = false
    }
    println("for循环：（高级for循环，加上了if守卫）结果为：" + res)
  }

  //方法二：在嵌套函数中使用return
  def add_outer() = {
    var res = 0

    def add_inner() {
      for (i <- 0 until 10) {
        if (i == 5) {
          return
        }
        res += i
      }
    }

    add_inner()
    res
  }

  //方法三：使用Breaks对象的break方法
  def breakFunction(){
    //跟java里面的break比较类似，相对来说，比较灵活好用；与breakable代码块配合使用
    
    import scala.util.control.Breaks._
    
    var res = 0
    breakable{
      for(i <- 0 until 10){
        if(i == 5 ){
          break;
        }
        res += i
      }
    }
  }

}