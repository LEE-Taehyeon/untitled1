package LV1

class P_Test14_자릿수더하기 {
  def solution(n: Int): Int = {
    /*
    var answer = 0
    var nCopy = n
    while(nCopy>0){
      answer += nCopy%10
      nCopy /= 10
    }
    answer
    함수형 코딩이 아님
     */
    (for(i<-n.toString) yield i.toString.toInt).sum
    //(for(i<-n.toString) yield i.asDigit).sum
    //n.toString.split("").map(_.toInt).sum //느림
    ////n.toString.map(_.toInt - '0').sum
  }
}
