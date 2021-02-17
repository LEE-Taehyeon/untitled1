import scala.collection.mutable.ArrayBuffer

object Array01 extends App {
  //고정길이 배열 : new Array[](), Array("a", "b", ... )
  val fixArr1 = new Array[Int](5)
  val fixArr2 = Array("Sam", "Kate", "Jane")

  println(fixArr1.mkString("Array(",",",")"))
  fixArr1(1) = 3
  fixArr1(4) = 100
  println(fixArr1.mkString("Array(",",",")"))

  println(fixArr2)//배열 객체 주소번지를 출력
  println(fixArr2.mkString("Array(",",",")"))//mkString메소드를 통해 원하는 대로 출력
  println("<--고정길이 배열-->")
  println()


  //가변길이 배열 : new ArrayBuffer[], ArrayBuffer[]()
  val nonFixArr1 = new ArrayBuffer[String]()
  val nonFixArr2 = ArrayBuffer[Int]()//ArrayBuffer 로 작성해도 된다.( []() 생략가능 )

  nonFixArr1+="John"
  nonFixArr1+="Kane"
  nonFixArr1+="Kane"
  nonFixArr1+="Jun"
  nonFixArr1+="Kane"
  nonFixArr1+="Kane"
  println(nonFixArr1.mkString("ArrayBuffer(",",",")"))
  nonFixArr1(2) = "Ruiz"
  println(nonFixArr1.mkString("ArrayBuffer(",",",")"))
  nonFixArr1-="Kane"
  println(nonFixArr1.mkString("ArrayBuffer(",",",")"))//최초 처음으로 해당되는 값을 제거
  //단, 배열버퍼에서 원소삭제는 비효율적이다. -> 남기고 싶은 값을 복사하는 것이 빠르다.
  println("<--가변길이 배열-->")
  println()


  //for문에서 배열을 i번째 원소마다 접근하는 방법
  for(i<-0 until (fixArr1.length,2)) println(i) // i에 해당하는 숫자는 2

  val func = 3 * (_:Double)
  println(func("6".toInt))
  println(func(3))

}
