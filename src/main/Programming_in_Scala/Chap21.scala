class Chap21 {

}

class Dollars(val amount:Int) extends AnyVal{
  override def toString: String = "$" + amount

  def dollarToInt()={
    this.toString.substring(1).toInt
  }
}

case class Foo(i:Int)

object Chap21 extends App{
  val d = new Dollars(34)
  println(new Dollars(d.dollarToInt().toInt+5))

  println(Foo(34))
  implicit def fooToInt(foo:Foo) = foo.i
  println(Foo(Foo(34)+5))
}

