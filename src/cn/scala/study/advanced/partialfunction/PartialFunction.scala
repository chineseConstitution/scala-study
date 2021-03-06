package cn.scala.study.advanced.partialfunction

object PartialFunction {
  def main(args: Array[String]): Unit = {

    //偏函数，是一种高级的函数形式
    //简单来说，偏函数是什么，其实就是没有定义好明确的输入参数的函数，函数体就是一连串的case语句
    //一般的函数
    //def getStudentGrade(name: String) = {
    //	...
    //}
    //偏函数是PartialFunction[A, B]类的一个实例
    //这个类有两个方法，一个是apply()方法，直接调用可以通过函数体内的case进行匹配，返回结果; 
    //另一个是isDefinedAt()方法，可以返回一个输入，是否跟任何一个case语句匹配
    //学生成绩查询案例

    val getStudentGrade: PartialFunction[String, Int] = {
      case "Leo" => 90; case "Jack" => 85; case "Marry" => 95
    }

    println(getStudentGrade("Leo"))
    println(getStudentGrade.isDefinedAt("Jack"))
    println(getStudentGrade.isDefinedAt("Tom"))

  }
}