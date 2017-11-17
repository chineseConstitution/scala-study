package cn.scala.study.advanced.fileoperation
import java.io._

object FileCopy {
  def main(args: Array[String]): Unit = {

    //    //案例: 结合java IO流，做一个文件拷贝的案例
    //    fileCopy();

    //    //结合Java IO流，写文件
    //    fileWrite();

    //    //递归遍历子目录
    //    val iterator = getSubdirIterator(new File("C://Users//Administrator//Desktop"))
    //    for (d <- iterator) println(d)

    //序列化以及反序列化（Java序列化和反序列化机制）

    //如果要序列化，那么就必须让类，有一个@SerialVersionUID，定义一个版本号
    //要让类继承一个Serializable trait

    @SerialVersionUID(42L) class Person(val name: String) extends Serializable
    val leo = new Person("leo")

    val oos = new ObjectOutputStream(new FileOutputStream("C://Users//Administrator//Desktop//test.obj"))
    oos.writeObject(leo)
    oos.close()

    val ois = new ObjectInputStream(new FileInputStream("C://Users//Administrator//Desktop//test.obj"))
    val restoredLeo = ois.readObject().asInstanceOf[Person]
    println(restoredLeo.name)

  }

  def fileCopy() {
    val fis = new FileInputStream(new File("C://Users//Administrator//Desktop//spark.txt"))
    val fos = new FileOutputStream(new File("C://Users//Administrator//Desktop//spark3.txt"))

    val buf = new Array[Byte](1024)
    fis.read(buf)
    fos.write(buf, 0, 1024)

    fis.close()
    fos.close()

  }

  def fileWrite() {
    val pw = new PrintWriter("C://Users//Administrator//Desktop//spark4.txt")
    pw.println("Hello World")
    pw.close()

  }

  def getSubdirIterator(dir: File): Iterator[File] = {
    val childDirs = dir.listFiles.filter(_.isDirectory)
    childDirs.toIterator ++ childDirs.toIterator.flatMap(getSubdirIterator _)
  }
}