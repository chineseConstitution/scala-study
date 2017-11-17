package cn.scala.study.advanced.annotation

/**
 *  什么是注解？
 *
 * 注解其实说白了，就是在我们的代码中，加入一些特殊的标记
 *
 * 特殊的标记大概长什么样子呢？
 * 我们之前学过一个很常用，和很经典的一个注解，其实就是@BeanProperty，让编译器自动生成属性的JavaBean风格的getter和setter方法
 * 除此之外，还在《文件操作实战详解》那一讲，讲过一个序列化的这个东西，@SerialUID（可能是错误的），指定一个序列化的版本号
 *
 * 注解是用来干嘛的？
 *
 * 然后我们的scala编译器，就可以在编译的时候，在碰到注解的时候，做一些特殊的操作。一个非常经典的例子就是
 * @BeanProperty注解，我们之前讲解过，给某个field添加了这个注解之后，scala编译器就会给field编译出新的JavaBean风格的getter和setter方法
 *
 * ------------------------------------------------------------------------
 *
 * scala中，在哪些地方可以添加注解呢？
 *
 * scala中，可以给类、方法、field、local variable、constructor / method / function parameter添加注解
 * 而且scala是支持给某个目标添加多个注解的
 *
 */
object AnnotationTest {
  def main(args: Array[String]): Unit = {

    //这里有一些特例：如果要给类的主构造函数添加注解，那么需要在构造函数前添加注解，并加上一对圆括号
    //比如说
    class Person @unchecked() (val name: String, val age: Int)
    //还可以给表达式添加注解，此时需要在表达式后面加上冒号以及注解，比如

    val scores = Map("Leo" -> 90, "Jack" -> 60)
    (scores.get("Leo"): @unchecked) match { case score => println(score) }

    //除此之外，还可以给类型参数和变量的类型定义添加注解

    //Scala中开发注解

    //要自己动手开发一个注解，就必须扩展Annotation trait，比如

    class Test extends annotation.Annotation

    @Test
    class myTest

    //注解的参数
    ////注解中，是可以有参数的，比如
    //class Test(var timeout: Int) extends annotation.Annotation
    //@Test(timeout = 100) class myTest
    //
    ////如果注解的参数是value的话，那么也可以不用指定注解的参数名，比如
    //class Test(var value: String) extends annotation.Annotation

  }
}
