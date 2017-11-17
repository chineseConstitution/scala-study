package cn.scala.study.objects

import scala.beans.BeanProperty

class Student {
  //  // 定义不带private的var field，此时scala生成的面向JVM的类时，会定义为private的name字段，并提供public的getter和setter方法
  //  // 而如果使用private修饰field，则生成的getter和setter也是private的
  //  // 如果定义val field，则只会生成getter方法
  //  // 如果不希望生成setter和getter方法，则将field声明为private[this]
  //
  //  var name = "leo"
  //
  //    // 如果只是希望拥有简单的getter和setter方法，那么就按照scala提供的语法规则，
  //    // 根据需求为field选择合适的修饰符就好：var、val、private、private[this]
  //    // 但是如果希望能够自己对getter与setter进行控制，则可以自定义getter与setter方法
  //    // 自定义setter方法的时候一定要注意scala的语法限制，签名、=、参数间不能有空格
  //    private var myName = "leo"
  //  
  //    def name="your name is " + myName
  //  
  //    def name_=(newValue: String) {
  //      println("you cannot edit your name!")
  //    }

  //  //如果你不希望field有setter方法，则可以定义为val，但是此时就再也不能更改field的值了
  //  //但是如果希望能够仅仅暴露出一个getter方法，并且还能通过某些方法更改field的值，那么需要综合使用private以及自定义getter方法
  //  //此时，由于field是private的，所以setter和getter都是private，对外界没有暴露；自己可以实现修改field值的方法；自己可以覆盖getter方法
  //    private var myName = "leo"
  //
  //    def updateName(newName: String) {
  //      if (newName == "leo1") myName = newName
  //      else print("not accept this new name!")
  //    }
  //
  //    def name = "your name is " + myName

  //  // 如果将field使用private来修饰，那么代表这个field是类私有的，在类的方法中，可以直接访问类的其他对象的private field
  //  // 这种情况下，如果不希望field被其他对象访问到，那么可以使用private[this]，意味着对象私有的field，只有本对象内可以访问到
  //  private var myAge = 0
  //
  //  def age_=(newValue: Int) {
  //    if (newValue > 0) myAge = newValue
  //    else print("illegal age!")
  //  }
  //
  //  def age = myAge
  //
  //  def older(s: Student) = {
  //    myAge > s.myAge
  //  }
  //
  //  //这个是错误的。因为把myAge定义为private[this]，只能在当前实例使用，
  //  //而在older函数中，传入的值肯定是其他的实例，所以访问不了myAge。
  //  //Private只能在当前对象使用，加上[this]只能在当前实例使用。
  //  //  private[this] var myAge = 0
  //  //  def age_=(newAge: Int) {
  //  //    if (newAge > 0) myAge = newAge
  //  //    else println("illegal age!")
  //  //  }
  //  //  def age=myAge
  //  //  def older(s: Student) = { myAge > s.myAge }

  // Scala的getter和setter方法的命名与java是不同的，是field和field_=的方式
  // 如果要让scala自动生成java风格的getter和setter方法，只要给field添加@BeanProperty注解即可
  // 此时会生成4个方法，name: String、name_=(newValue: String): Unit、getName(): String、setName(newValue: String): Unit

  @BeanProperty var name: String = _

}

// class Student(@BeanProperty var name: String)

//// Scala中，可以给类定义多个辅助constructor，类似于java中的构造函数重载
//// 辅助constructor之间可以互相调用，而且必须第一行调用主constructor
//class Student {
//  private var name = ""
//  private var age = 0
//  def this(name: String) {
//    this()
//    this.name = name
//  }
//  def this(name: String, age: Int) {
//    this(name)
//    this.age = age
//  }
//}


//// Scala中，主constructor是与类名放在一起的，与java不同
//// 而且类中，没有定义在任何方法或者是代码块之中的代码，就是主constructor的代码，这点感觉没有java那么清晰
//class Student(val name: String, val age: Int) {
//  println("your name is " + name + ", your age is " + age)
//}

//// 主constructor中还可以通过使用默认参数，来给参数默认的值
//class Student(val name: String = "leo", val age: Int = 30) {
//  println("your name is " + name + ", your age is " + age)
//}

// 如果主constrcutor传入的参数什么修饰都没有，比如name: String，
// 那么如果类内部的方法使用到了，则会声明为private[this] name；
// 否则没有该field，就只能被constructor代码使用而已，仅仅在初始化的时候使用一下。



