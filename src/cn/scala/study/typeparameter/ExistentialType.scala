package cn.scala.study.typeparameter

object ExistentialType {
  def main(args: Array[String]): Unit = {
    // 在Scala里，有一种特殊的类型参数，就是Existential Type，存在性类型。
    // 这种类型务必掌握是什么意思，因为在spark源码实在是太常见了！

    //    Array[T] forSome { type T }
    //    Array[_]
    def foo1[T](x:Array[T]) = println(x.length)
    foo1(Array[String]("foo","bar","baz"))
    
    def foo2(x : Array[T] forSome { type T}) = println(x.length)
    foo2(Array[String]("foo", "bar", "baz"))
    
    def foo3(x : Array[_]) = println(x.length)
    foo3(Array[String]("foo", "bar", "baz"))
    
    def foo4(x : Array[T] forSome { type T <: CharSequence}) = x.foreach(y => println(y.length))
    foo4(Array[String]("foo", "bar", "baz"))
  }
}