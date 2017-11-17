package cn.scala.study.typeparameter.classandfunction

object GenericityClass {
  def main(args: Array[String]): Unit = {
    // 类型参数是什么？类型参数其实就类似于Java中的泛型。
    // 先说说Java中的泛型是什么，比如我们有List a = new ArrayList()，接着a.add(1)，没问题，a.add("2")，然后我们a.get(1) == 2，对不对？
    // 肯定不对了，a.get(1)获取的其实是个String——"2"，String——"2"怎么可能与一个Integer类型的2相等呢？
    // 所以Java中提出了泛型的概念，其实也就是类型参数的概念，此时可以用泛型创建List，List a = new ArrayList[Integer]()，
    // 那么，此时a.add(1)没问题，而a.add("2")呢？就不行了，因为泛型会限制，只能往集合中添加Integer类型，这样就避免了上述的问题。

    // 那么Scala的类型参数是什么？其实意思与Java的泛型是一样的，也是定义一种类型参数，
    // 比如在集合，在类，在函数中，定义类型参数，然后就可以保证使用到该类型参数的地方，就肯定，也只能是这种类型。从而实现程序更好的健壮性。
    // 此外，类型参数是Spark源码中非常常见的，因此同样必须掌握，才能看懂spark源码。

    //1、泛型类（案例：新生报到）
    val leo = new Student[Int](111)
    println(leo.getSchoolId(222))

    val weide = new Student("1")
    println(weide.getSchoolId("2"))
    //1、泛型类（案例：新生报到）
    //2、泛型函数（案例：卡片售卖机）
    //3、上边界Bounds（案例：在派对上交朋友）
    //4、下边界Bounds（案例：领身份证）
    //5、View Bounds（案例：跟小狗交朋友）
    //6、Context Bounds（案例：使用Scala内置的比较器比较大小）
    //7、Manifest Context Bounds（案例：打包饭菜）
    //8、协变和逆变（案例：进入会场）
    //9、Existential Type
  }
}

// 泛型类，顾名思义，其实就是在类的声明中，定义一些泛型类型，然后在类内部，比如field或者method，就可以使用这些泛型类型。
// 使用泛型类，通常是需要对类中的某些成员，比如某些field和method中的参数或变量，进行统一的类型限制，这样可以保证程序更好的健壮性和稳定性。
// 如果不使用泛型进行统一的类型限制，那么在后期程序运行过程中，难免会出现问题，比如传入了不希望的类型，导致程序出问题。
// 在使用类的时候，比如创建类的对象，将类型参数替换为实际的类型，即可。
// Scala自动推断泛型类型特性：直接给使用了泛型类型的field赋值时，Scala会自动进行类型推断。

// 案例：新生报到，每个学生来自不同的地方，id可能是Int，可能是String
class Student[T](val localId: T) {
  def getSchoolId(hukouId: T) = "S-" + hukouId + "-" + localId
}