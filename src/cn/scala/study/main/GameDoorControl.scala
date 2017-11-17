package cn.scala.study.main

/**
 * 综合案例：游戏厅门禁
 * readLine: readLine允许我们从控制台读取用户输入的数据，类似于java中的System.in和Scanner的作用。
 */
object GameDoorControl {
  def main(args: Array[String]): Unit = {
    val name = readLine("Welcome to Game House,Please tell me your name:")
    print("Thanks. Then please tell me your age: ")
    val age = readInt();
    if (age > 18) {
      printf("Hi, %s, you are %d years old, so you are legel to come here!", name, age)
    } else {
      printf("Sorry, boy, %s, you are only %d years old. you are illegal to come here!", name, age)
    }
  }
}