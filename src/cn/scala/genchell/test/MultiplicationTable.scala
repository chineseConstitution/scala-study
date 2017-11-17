package cn.scala.genchell.test

/**
 *
 * 多重for循环，九九乘法表
 * @author Administrator
 *
 */
object MultiplicationTable {
  def main(args: Array[String]): Unit = {
    //for (i <- 1 to 9; j <- 1 to 9) {
    //       print(i + " * " +j + " = " + i * j + " ");
    //       if (j == i) {
    //         println();
    //       }

          for (i <- 1 to 9; j <- 1 to i) {
            if (j == i) {
              println(i + " * " + j + " = " + i * j + " ");
            } else {
              print(i + " * " + j + " = " + i * j + " ");
            }
          }

    //    var i = 1;
    //    while (i < 10) {
    //      var j = 1;
    //      while (j <= i) {
    //        print(i + " * " + j + " = " + i * j + "   ");
    //        if (j == i) {
    //          println();
    //        }
    //        j += 1;
    //      }
    //      i += 1;
    //    }

  }
}