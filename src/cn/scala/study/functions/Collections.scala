package cn.scala.study.functions
/**
 * 函数是编程之集合操作
 * 1、Scala的集合体系结构
 * 2、List
 * 3、LinkedList
 * 4、Set
 * 5、集合的函数式编程
 * 6、函数式编程综合案例：统计多个文本内的单词总数
 */
object Collections {
  def main(args: Array[String]): Unit = {
    // 1、Scala的集合体系结构
    // Scala中的集合体系主要包括：Iterable、Seq、Set、Map。其中Iterable是所有集合trait的根trait。
    // 这个结构与Java的集合体系非常相似。

    // Scala中的集合是分成可变和不可变两类集合的，
    // 其中可变集合就是说，集合的元素可以动态修改，而不可变集合的元素在初始化之后，就无法修改了。
    // 分别对应scala.collection.mutable和scala.collection.immutable两个包。

    // Seq下包含了Range、ArrayBuffer、List等子trait。
    // 其中Range就代表了一个序列，通常可以使用“1 to 10”这种语法来产生一个Range。
    // ArrayBuffer就类似于Java中的ArrayList。
    // List代表一个不可变的列表

    //2、List
    //List的创建
    val list = List(1, 2, 3, 4)
    // List有head和tail，head代表List的第一个元素，tail代表第一个元素之后的所有元素，
    println(list.head)
    println(list.tail)

    // List有特殊的::操作符，可以用于将head和tail合并成一个List，
    // ::这种操作符要清楚，在spark源码中都是有体现的，一定要能够看懂！
    // 如果一个List只有一个元素，那么它的head就是这个元素，它的tail是Nil
    println(0 :: list)

    decorator(list, "Hi,")

    // 3、LinkedList
    // LinkedList代表一个可变的列表，使用elem可以引用其头部，使用next可以引用其尾部
    val list2 = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5)
    println(list2)
    var currentList = list2
    println(currentList)
    while (currentList != Nil) {
      currentList.elem = currentList.elem * 2
      print(currentList.elem + ",")
      currentList = currentList.next
    }
    println("\n" + currentList)

    // 案例：使用while循环将LinkedList中，从第一个元素开始，每隔一个元素，乘以2
    val list3 = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var currentList3 = list3
    var first = true
    while (currentList3 != Nil && currentList3.next != Nil) {
      if (first) {
        currentList3.elem = currentList3.elem * 2
        first = false
        print(currentList3.elem + ",")
      }
      currentList3 = currentList3.next.next
      if (currentList3 != Nil) {
        currentList3.elem = currentList3.elem * 2
        print(currentList3.elem + ",")
      }
    }

    // 4、Set
    // Set代表一个没有重复元素的集合
    // 将重复元素加入Set是没有用的
    val s = Set(1, 2, 3)
    s + 1
    s + 4
    println(s)
    // 而且Set是不保证插入顺序的，也就是说，Set中的元素是乱序的
    val s1 = new scala.collection.mutable.HashSet[Int]()
    s1 += 1
    s1 += 2
    s1 += 5
    println(s1)
    // LinkedHashSet会用一个链表维护插入顺序
    val s2 = new scala.collection.mutable.LinkedHashSet[Int]()
    s2 += 1
    s2 += 2
    s2 += 5
    println(s2)
    // SrotedSet会自动根据key来进行排序
    val s3 = scala.collection.mutable.SortedSet("orange", "apple", "banana")
    println(s3)

    // 5、集合的函数式编程
    // 集合的函数式编程非常非常非常之重要！！！
    // 必须完全掌握和理解Scala的高阶函数是什么意思，Scala的集合类的map、flatMap、reduce、reduceLeft、foreach等这些函数，就是高阶函数，因为可以接收其他函数作为参数
    // 高阶函数的使用，也是Scala与Java最大的一点不同！！！因为Java里面是没有函数式编程的，也肯定没有高阶函数，也肯定无法直接将函数传入一个方法，或者让一个方法返回一个函数
    // 对Scala高阶函数的理解、掌握和使用，可以大大增强你的技术，而且也是Scala最有诱惑力、最有优势的一个功能！！！
    // 此外，在Spark源码中，有大量的函数式编程，以及基于集合的高阶函数的使用！！！所以必须掌握，才能看懂spark源码
    
    // map案例实战：为List中每个元素都添加一个前缀
    List("Leo", "Jen", "Peter", "Jack").map("name is " + _)

    // faltMap案例实战：将List中的多行句子拆分成单词
    List("Hello World", "You Me").flatMap(_.split(" "))

    // foreach案例实战：打印List中的每个单词
    List("Hello World!", "You Me").foreach(print(_))

    // zip案例实战：对学生姓名和学生成绩进行关联
    List("Leo", "Jen", "Peter", "Jack").zip(List(100, 90, 75, 83))

  }

  // 案例：用递归函数来给List中每个元素都加上指定前缀，并打印加上前缀的元素
  def decorator(i: List[Int], prefix: String) {
    if (i != Nil) {
      println(prefix + i.head)
      decorator(i.tail, prefix)
    }
  }
}