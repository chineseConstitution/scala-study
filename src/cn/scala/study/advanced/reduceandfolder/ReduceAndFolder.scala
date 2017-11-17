package cn.scala.study.advanced.reduceandfolder

object ReduceAndFolder {
  def main(args: Array[String]): Unit = {

    //map操作，一对一映射

    val scoreMap = Map("leo" -> 90, "jack" -> 60, "tom" -> 70)
    val names = List("leo", "jack", "tom")
    names.map(scoreMap(_))

    //flatMap操作，一对多映射

    val scoreMap2 = Map("leo" -> List(80, 90, 60), "jack" -> List(70, 90, 50), "tom" -> List(60, 70, 40))
    names.map(scoreMap2(_))
    names.flatMap(scoreMap2(_))

    //collect操作，结合偏函数使用

    "abc".collect { case 'a' => 1; case 'b' => 2; case 'c' => 3 }

    //foreach操作，遍历

    names.foreach(println _)

    //reduce操作
    // 10 -1-2-3-4=2；
    println(List(1, 2, 3, 4).reduceLeft(_ - _))
    println(List(1, 2, 3, 4).reduceRight(_ - _))

    //fold操作
    //4-10=-6；3-（-6）=9；2-9=-7；1-（-7）=8；
    println(List(1, 2, 3, 4).foldLeft(10)(_ - _))
    println(List(1, 2, 3, 4).foldRight(10)(_ - _))

  }
}