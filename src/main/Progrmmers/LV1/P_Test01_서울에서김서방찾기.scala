package LV1

//Programmers_서울에서김서방찾기
class P_Test01 {
  def solution(seoul: Vector[String]): String = {
    /*
    var answer = ""
    breakable{ for(i<-0 until seoul.length) if(seoul(i)=="Kim") { answer = "김서방은 "+i+"에 있다"; break } }

    answer
    함수형 코딩이 아니다.
     */
    "김서방은 "+seoul.indexOf("Kim", 4)+"에 있다"
  }
}
