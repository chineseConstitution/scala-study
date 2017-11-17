package cn.scala.study.main

object IfTest {
  def main(args: Array[String]): Unit = {

    /**
     * ·if表达式的定义：在Scala中，if表达式是有值的，就是if或者else中最后一行语句返回的值。
     * ·例如，val age = 30; if (age > 18) 1 else 0
     * ·可以将if表达式赋予一个变量，例如，val isAdult = if (age > 18) 1 else 0
     * ·另外一种写法，var isAdult = -1; if(age > 18) isAdult = 1 else isAdult = 0，
     *  但是通常使用上一种写法
     */
    var age = 32
    //方法1
    var isAdult1 = if (age > 18) 1 else 0
    println("isAdult1:" + isAdult1)
    //方法2
    var isAdult2 = -1
    if (age > 18) isAdult2 = 1 else isAdult2 = 0
    println("isAdult2:" + isAdult2)

    /**
     * ·if表达式的类型推断：由于if表达式是有值的，而if和else子句的值类型可能不同，此时if表达式的值是什么类型呢？
     *  Scala会自动进行推断，取两个类型的公共父类型。
     * ·例如，if(age > 18) 1 else 0，表达式的类型是Int，因为1和0都是Int
     * ·例如，if(age > 18) "adult" else 0，此时if和else的值分别是String和Int，则表达式的值是Any，
     *  Any是String和Int的公共父类型
     * ·如果if后面没有跟else，则默认else的值是Unit，也用()表示，类似于java中的void或者null。例如，val age = 12; if(age > 18) "adult"。此时就相当于if(age > 18) "adult" else ()。
     *
     */

    //    //此时if和else的值都是Int，则表达式的值是Int
    //    var flag = if (age > 18) {
    //      1
    //    }else {
    //      0
    //    }

    //    //此时if和else的值分别是String和Int，则表达式的值是Any，Any是String和Int的公共父类型
    //    var flag = if (age > 18) {
    //      "adult"
    //    }else {
    //      0
    //    }

    //如果if后面没有跟else，则默认else的值是Unit，也用()表示，类似于java中的void或者null。
    //例如，val age = 12; if(age > 18) "adult"。此时就相当于if(age > 18) "adult" else ()。

    //val flag = if(age > 18) "adult"
    //val flag = if(age > 18) "adlut" else () 

    /**
     * ·将if语句放在多行中：默认情况下，REPL只能解释一行语句，但是if表达式通常需要放在多行。
     * ·可以使用{}的方式，比如以下方式，或者使用:paste和ctrl+D的方式。
     */
    var flag = if (age > 18) {
      "adult"
    } else if (age > 12)
      "teenager"
    else
      "children"
    println(flag)

    /**
     *  语句终结符、块表达式
     *  ·默认情况下，scala不需要语句终结符，默认将每一行作为一个语句
     *  ·一行放多条语句：如果一行要放多条语句，则必须使用语句终结符
     *  ·例如，使用分号作为语句终结符，var a, b, c = 0; if(a < 10) { b = b + 1; c = c + 1 }
     *  ·通常来说，对于多行语句，还是会使用花括号的方式
     *   if(a < 10) {
     *       b = b + 1
     *       c = c + 1
     *   }
     */
    //1、语句终结符
    var a, b, c = 0; if (a < 10) { b = b + 1; c = c + 1 }
    if (a < 10) {
      b = b + 1
      c = c + 1
    }
    println(a + "," + b + "," + c)

    //2、块表达式，指的就是{}中的值，其中可以包含多条语句，最后一个语句的值就是块表达式的返回值。
    var d = if (a < 10) { b = b + 1; c + 1 }
    println(d)

    
    /**
     * ·print和println：print打印时不会加换行符，而println打印时会加一个换行符。
     * ·例如，print("Hello World"); println("Hello World")
		 * ·printf：printf可以用于进行格式化
     * ·例如，printf("Hi, my name is %s, I'm %d years old.\n", "Leo", 30)
     * ·readLine: readLine允许我们从控制台读取用户输入的数据，类似于java中的System.in和Scanner的作用。
     */
    //3、输入和输出
    println("Hello World!")
    print("Hello World!");
    printf("Hi, my name is %s, I'm %d years old.\n", "Leo", 30)
  }
}