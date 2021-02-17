//Scala_for_the_Impatient
//Chapter 14. 패턴매칭
class Chap14_패턴매칭 {

}

object chap14 extends App {
  //타입패턴
  // - obj의 요소를 돌면서 case 검사
  val obj = List(2, 4, "Ste", 32.0, 'e', false)

  def matching(o: Any) = o match {
    case i: Int => println("Int")
    case s: String => println("String")
    case c: Char => println("Char")
    case d: Double => println("Double")
    case b: Boolean => println("Boolean")
    case _=>println("Nothing")
  }
  for(i<-obj) matching(i)


  //음수, 양수, 0을 구분짓는 패턴매칭
  def matchingFor(vec:Vector[Int]) = {
    for(i<-vec){
      i match {
        case _ if i<0 => println("minus")
        case _ if i>0 => println("plus")
        case _ if i==0 => println("zero")
        case _ => println("Not Number")
      }
    }
  }
  matchingFor(Vector(3,-2,59,324,0))
  println("<--for문으로 패턴매칭-->")
  println()


  //배열 매칭
  def matchArr(arr:Array[Any])={
    arr match {
      case Array(0) => println("0만 들어있는 배열")
      case Array(x, y) => println("원소가 두개인 배열")
      case Array(0,_*) => println("0으로 시작하는 모든 배열")
      case _ => println("예외")
    }
  }
  matchArr(Array(0,3,52,23))
  matchArr(Array(3,5))
  matchArr(Array(34,5,3,0))
  matchArr(Array(0))
  println("<--배열 매칭-->")
  println()


  //리스트 매칭
  def matchList(list:List[Any])={
    list match {
      case 0 :: Nil => println("0과 Nil이 연결된 리스트")
      case x :: y :: Nil => println("두 개가 연결된 리스트")
      case 0 :: tail => println("0과 꼬리가 연결된 리스트")
      case _ => println("이외")
    }
  }
  matchList(List(0,3))
  matchList(List(0))
  matchList(List(3,5))
  matchList(List(0,503,2,4,3,3))
  matchList(List(4,5,4,3,4,5,4))

  println("<--리스트 매칭-->")
  println()


  //변수 선언에서의 패턴
  val (x,y) = (2,34)
  println(x)
  println(y)

  val (q, r) = BigInt(10)/%3
  println(q)
  println(r)
  println("<--변수 선언에서의 패턴매칭-->")
  println()


  //케이스클래스, copy메소드
  abstract class Amount
  case class Dollar(value:Int) extends Amount
  case class Currency(value:Double, unit:String) extends Amount

  val amt = Currency(29.95, "EUR")
  println(amt.copy(value=19.95))


  println("<--케이스클래스-->")
  println()




}
