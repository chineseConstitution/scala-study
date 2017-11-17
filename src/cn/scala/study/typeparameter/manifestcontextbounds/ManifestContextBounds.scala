package cn.scala.study.typeparameter.manifestcontextbounds

object ManifestContextBounds {
  def main(args: Array[String]): Unit = {
    // 在Scala中，如果要实例化一个泛型数组，就必须使用Manifest Context Bounds。
    // 也就是说，如果数组元素类型为T的话，需要为类或者函数定义[T: Manifest]泛型类型，
    // 这样才能实例化Array[T]这种泛型数组。
    // 7、Manifest Context Bounds（案例：打包饭菜）
    val m1 = new Meat("pork")
    val m2 = new Meat("beef")
    val m3 = new Meat("lamb")
    val v1 = new Vegetable("potato")
    val v2 = new Vegetable("tomato")

    packageFood(m1, m2, m3, v1, v2)

  }

  // 案例：打包饭菜（一种食品打成一包）
  def packageFood[T: Manifest](food: T*) = {
    val foodPackage = new Array[T](food.length)
    for (i <- 0 until food.length) foodPackage(i) = food(i)
    println(foodPackage.mkString("<", ",", ">"))
    foodPackage
  }
}

class Meat(val name: String)

class Vegetable(val name: String)

