import scala.collection.mutable.ArrayBuffer

object Test01 extends App {
  //to 는 앞에가 작은수 뒤에 큰수가 와야함
  for(i<- (10 to 3).reverse) println(i)

  //map함수 사용
  println(Array(3.42,46.4,363.33).map((x:Double)=>2*x).toVector)

  //할당은 Unit타입
  var x:Unit=()
  var y = 0
  x=y=1
  println(x)//결과값 : ()

  //for문 탐색
  val arr = ArrayBuffer(1,2,3,4,5,6,7)
  for(i<-0 until (arr.length, 2)) println(arr(i))


  //zip, toMap
  val symbols = Array("<", "_", ">", "=")
  val counts = Array(2,4,6,1)
  val pairs = symbols zip counts
  println(pairs.toMap)
}





//REPL에서 테스트
class Test {
  def printTest(x: String): Unit = println(x)
}

class Counter{
  private var value = 0
  def increment(){value+=1}
  def current() = value
}

class Student(name:String, age:Int, id:String){
  println("NAME = "+name+" AGE = "+age+" ID = "+id)
}


/////////////////////////
trait Logged{
  def log(msg:String) {}
}

class SavingsAccount extends Logged{
  def withdraw(amount:Double): Unit = {
    if(amount>1000) log("Insufficient funds")
    else log("No money")
  }
}

//이 트레이트 추가 전까지는 객체를 생성해도 withdraw메소드를 이용하여 어떤 결과값도 나타낼 수 없다.
//하지만 이 트레이트 추가 후 객체를 생성하면 withdraw메소드를 이용하여 어떤 결과값을 나타낼 수 있다.
trait ConsoleLogger extends Logged{
  override def log(msg: String): Unit = println(msg)
}


//레이어드 트레이트
trait TimestampLogger extends Logged{
  override def log(msg: String): Unit = super.log(new java.util.Date() + " " + msg)
}

trait ShortLogger extends Logged{
  //val maxLength = 15
  val maxLength:Int
  override def log(msg: String) = {
    super.log(
      if(msg.length<=maxLength) msg else msg.substring(0, maxLength-3) + "...")
  }
}





