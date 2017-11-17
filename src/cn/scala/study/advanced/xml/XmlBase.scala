package cn.scala.study.advanced.xml

object XmlBase {
  def main(args: Array[String]): Unit = {
    //1、scala中定义xml
    //scala对xml有很好的支持，可以直接在scala代码中定义一个xml文档元素
    //val books = <books><book>my first scala book</book></books>
    //此时doc的类型是scala.xml.Elem，也就是一个xml元素

    //scala还可以直接定义多个同级别的xml元素
    //val books = <book>my first scala book</book><book>my first spark book</book>
    //此时doc的类型是scala.xml.NodeBuffer，也就是一个xml节点序列

    //XML节点类型
    //Node类是所有XML节点类型的父类型，两个重要的子类型是Text和Elem。
    //Elem表示一个XML元素，也就是一个XML节点。scala.xml.Elem类型的label属性，返回的是标签名，child属性，返回的是子元素。
    //scala.xml.NodeSeq类型，是一个元素序列，可以用for循环，直接遍历它。
    //可以通过scala.xml.NodeBuffer类型，来手动创建一个节点序列

    val booksBuffer = new scala.xml.NodeBuffer
    booksBuffer += <book>book1</book>
    booksBuffer += <book>book2</book>
    val books: scala.xml.NodeSeq = booksBuffer

    //xml元素的属性

    //scala.xml.Elem.attributes属性，可以返回这儿xml元素的属性，是Seq[scala.xml.Node]类型的，继续调用text属性，可以拿到属性的值

    val book = <book id="1" price="10.0">book1</book>
    val bookId = book.attributes("id").text

    //还可以遍历属性

    for (attr <- book.attributes) println(attr)

    //还可以调用book.attributes.asAttrMap，获取一个属性Map

    //2、在xml中嵌入scala代码
    val books2 = Array("book1", "book2")

    <books><book>{ books2(0) }</book><book>{ books2(1) }</book></books>
    <books>{ for (book <- books2) yield <book>{ book }</book> }</books>

    //还可以在xml属性中嵌入scala代码

    <book id={ books2(0) }>{ books2(0) }</book>

    //3、修改xml元素

    //默认情况下，scala中的xml表达式是不可改变的；如果要修改xml元素的话，必须拷贝一份再修改

    val books3 = <books><book>book1</book></books>

    //添加一个子元素
    val booksCopy = books3.copy(child = books3.child ++ <book>book2</book>)

    val book3 = <book id="1">book1</book>

    import scala.xml._

    //修改一个属性
    val bookCopy = book3 % Attribute(null, "id", "2", Null)

    //添加一个属性
    val bookCopy3 = book3 % Attribute(null, "id", "2", Attribute(null, "price", "10.0", Null))

    //说点闲话
    //如果大家真的对java比较精通的话
    //然后过来学习这个scala，就会发现有个特点
    //
    //java的功能是非常强大的
    //但是，从各个方面来看，比如io、xml操作、第三方类库的支持、socket、gui界面编程、jdbc访问数据库等等，scala都比java差很多
    //
    //之所以现在scala有点火，有些人推崇这个scala
    //其实主要是因为spark是用scala作为主要的语言开发的（但是spark底层的源码，其实都是java）
    //类加载器、线程、反射、线程池等等这些东西，全部都是java底层，外部命令的执行（ProcessBuilder）

    //4、加载和写入外部xml文件

    import scala.xml._
    import java.io._

    //使用scala的XML类加载
    val books4 = XML.loadFile("C://Users//Administrator//Desktop//books.xml")

    //使用Java的FileInputStream类加载
    val books5 = XML.load(new FileInputStream("C://Users//Administrator//Desktop//books.xml"))

    //使用Java的InputStreamReader类指定加载编码
    val books6 = XML.load(new InputStreamReader(new FileInputStream("C://Users//Administrator//Desktop//books.xml"), "UTF-8"))

    //将内存中的xml对象，写入外部xml文档
    XML.save("C://Users//Administrator//Desktop//books2.xml", books6)

  }
}