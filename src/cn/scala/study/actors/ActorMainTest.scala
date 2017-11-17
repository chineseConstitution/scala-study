package cn.scala.study.actors

object ActorMainTest {
  def main(args: Array[String]): Unit = {
    // Scala的Actor类似于Java中的多线程编程。
    // 但是不同的是，Scala的Actor提供的模型与多线程有所不同。
    // Scala的Actor尽可能地避免锁和共享状态，从而避免多线程并发时出现资源争用的情况，进而提升多线程编程的性能。
    // 此外，Scala Actor的这种模型还可以避免死锁等一系列传统多线程编程的问题。

    // Spark中使用的分布式多线程框架，是Akka。
    // Akka也实现了类似Scala Actor的模型，其核心概念同样也是Actor。
    // 因此只要掌握了Scala Actor，那么在Spark源码研究时，至少即可看明白Akka Actor相关的代码。
    // 但是，换一句话说，由于Spark内部有大量的Akka Actor的使用，因此对于Scala Actor也至少必须掌握，这样才能学习Spark源码。

    //课程大纲
    //1、Actor的创建、启动和消息收发（案例：Actor Hello World）
    //2、收发case class类型的消息（案例：用户注册登录后台接口）
    //3、Actor之间互相收发消息（案例：打电话）
    //4、同步消息和Future

    //scala的高版本中抛弃了actor，而使用akka来进行消息的收发

  }
}