//Scala_for_the_Impatient
//Chapter 12. 고차함수
class Chap12_고차함수 {

}

object chap12 extends App{
  //값으로서 함수
  import scala.math._
  val func = ceil _//올림
  println(func(5.4))
  println("<---값으로서 함수--->")

  //익명함수
  (x:Double)=>2*x
  val double = (x:Double)=>2*x
  def triple(x:Double)=x*3
  Array(3.14, 4.2, 2.0).map((x:Double)=>x*4)
  println(double(3))
  println(triple(4))
  println("<---익명함수--->")

  //함수를 인자로 받는 함수:고차함수
  def funcOfFunction(f:(Double)=>Double, x:Double)=f(x)
  println(funcOfFunction(ceil, 1.44))
  println(funcOfFunction(sqrt, 1.44))

  def mulBy(factor:Int)=(x:Int)=>factor*x
  val quintuple = mulBy(5)
  println(quintuple(20))
  println("<---함수를 인자로 받는 함수--->")
  println("<---고차함수--->")

  //인자추론
  def valueAtOneQuarter(f:(Double)=>Double)=f(0.25)
  println(valueAtOneQuarter((x:Double)=>x*3))
  println(valueAtOneQuarter((x)=>x*3))
  println(valueAtOneQuarter(x=>x*3))
  println(valueAtOneQuarter(3*_))
  println("<---인자추론--->")


  //유용한 고차함수
  //예제 Int, Int를 받아 해당 숫자만큼 별모양을 출력하는 함수를 만들어라
  //ex) func(3, 4) ***
  //               ***
  //               ***
  //               ***
  def makeStarSquare(row:Int, column:Int)=for(i<-1 to column) println("*" * row)
  println(makeStarSquare(3, 4))
  println("<---유용한 고차함수--->")

  //이항함수
  println("Mary had a little lamb".split(" ").sortWith(_.length < _.length).toVector)
  println("<---이항함수--->")

  //클로저(closure)
  var more = 1
  def addMore(x:Int)=x+more
  println(addMore(1))
  more = 9999
  println(addMore(1))
  println("<---클로저--->")


  //커링
  def mul(x:Int)(y:Int)=x*y
  val p = mul (3)_
  println(p(3))
  println("<---커링--->")




}