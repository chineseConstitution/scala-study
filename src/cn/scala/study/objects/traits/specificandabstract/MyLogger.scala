package cn.scala.study.objects.traits.specificandabstract

////2-3 在trait中覆盖抽象方法
//// 在trait中，是可以覆盖父trait的抽象方法的
//// 但是覆盖时，如果使用了super.方法的代码，则无法通过编译。因为super.方法就会去掉用父trait的抽象方法，此时子trait的该方法还是会被认为是抽象的
//// 此时如果要通过编译，就得给子trait的方法加上abstract override修饰
trait MyLogger extends Logger {
  abstract override def log(msg: String) { super.log(msg) }
}
