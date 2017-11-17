package cn.scala.study.main

/**
 * Map与Tuple
 */
object MapAndTuple {
  def main(args: Array[String]): Unit = {
    // 创建一个不可变的Map
    // val ages = Map("leo" -> 30, "jen" -> 25, "jack" -> 23)
    // println(ages("leo"))

    // 创建一个可变的Map
    val ages = scala.collection.mutable.Map("Leo" -> 30, "Jen" -> 25, "Jack" -> 23)
    //ages("Leo") = 31
    //映射.get(键)这样的调用返回一个Option对象， 要么是Some(键对应的值)， 要么是None。
    println("ages.get(\"Leo\"):" + ages.get("Leo"));
    println("ages.get(\"tom\"):" + ages.get("tom"));

    // 使用另外一种方式定义Map元素
    // val ages = Map(("Leo", 30), ("Jen", 25), ("Jack", 23))
    // 创建一个空的HashMap
    // val ages = new scala.collection.mutable.HashMap[String, Int]

    // 获取指定key对应的value，如果key不存在，会报错
    // val leoAge = ages("leo")

    //使用contains函数检查key是否存在
    //val leoAge = if (ages.contains("leo")) ages("leo") else 0
    //getOrElse函数
    val leoAge = ages.getOrElse("leo", 0)
    println(leoAge)

    //更新Map中的元素
    ages("leo") = 31
    //增加多个元素
    ages += ("Mike" -> 35, "Tom" -> 40)
    //移除元素
    ages -= "Mike"

    // 更新不可变的map
    val ages2 = ages + ("Mike" -> 36, "Tom" -> 40)
    // 移除不可变map的元素
    val ages3 = ages - "Tom"

    //遍历map的entrySet
    for ((ket, value) <- ages) println(ket + "," + value)
    //遍历map的key
    for (key <- ages.keySet) println(key)
    //遍历map的value
    for (value <- ages.values) println(value)
    //生成新的map，反转key和value
    val newages = for ((key, value) <- ages) yield (value, key)
    //打印反转后的map
    for ((ket, value) <- newages) println(ket + "," + value)

    // SortedMap可以自动对Map的key的排序
    val ages4 = scala.collection.immutable.SortedMap("leo" -> 30, "alice" -> 15, "jen" -> 25)
    for ((key, value) <- ages4) println(key + "," + value)

    // LinkedHashMap可以记住插入entry的顺序
    val ages5 = new scala.collection.mutable.LinkedHashMap[String, Int]
    ages5("leo") = 30
    ages5("alice") = 15
    ages5("jen") = 25
    for ((key, value) <- ages5) println(key + "," + value)

    //Java Map与Scala Map的隐式转换
    import scala.collection.JavaConversions.mapAsScalaMap
    val javaScores = new java.util.HashMap[String, Int]()
    javaScores.put("Alice", 10)
    javaScores.put("Bob", 3)
    javaScores.put("Cindy", 8)
    val scalaScores: scala.collection.mutable.Map[String, Int] = javaScores
    for ((key, value) <- scalaScores) println(key + "," + value)

    import scala.collection.JavaConversions.mapAsJavaMap
    import java.awt.font.TextAttribute._
    val scalaAttrMap = Map(FAMILY -> "Serif", SIZE -> 12)
    val font = new java.awt.Font(scalaAttrMap)
    println(font)

    //简单的Tuple
    val t = ("leo", 30)

    //访问Tuple
    println(t._1 + "," + t._2)

    //zip操作
    val names = Array("leo", "jack", "mike")
    val ages6 = Array(30, 24, 26)
    val nameAges = names.zip(ages6)
    println(nameAges)
    for ((name, age) <- nameAges) println(name + ":" + age)
  }
}