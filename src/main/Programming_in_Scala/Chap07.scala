class Chap07 {

}

object chap07 extends App{
  //for 표현식
  val arr = Array(1,2,3,4,5,6,7,8,9,10)

  for(i<-arr) println(i)
  println("for표현식")
  println()

  //가드(필터링)가 들어간 for표현식
  for(i<-arr if i%3==0) println(i)
  for(i<-arr if i%2==0 && i!=4) println(i)
  println("가드(필터링)가 들어간 for표현식")
  println()

  //중첩 for표현식
  val array = Array("france", "england", "norway", "for")
  for(i<-arr; j<-array if i%2==0 && j(0)=='f') println(j+" "+i)
  println("중첩 for표현식")
  println()

  //for문안에 변수 바인딩
  for(i<-arr; form = 4-i if i%4==0) println(form)
  println("for문 안에 변수 바인딩")
  println()

  //match
  val caseSelect =
    array(0) match{
      case "france" => "프랑스"
      case "england" => "영국"
      case "norway" => "노르웨이"
      case _ => "해당없음"
    }

  println(caseSelect)
  println("match")
  println()

  //n단을 입력받으면 해당 구구단을 출력하는 프로그램을 만들자
  def gugu(n:Int)={
    for(i<-1 to 9) println(n +" X " +i+" = "+n*i)
  }

  gugu(6)






}
