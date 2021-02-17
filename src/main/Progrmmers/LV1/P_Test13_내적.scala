package LV1

class P_Test13_내적 {
  def solution(a: Vector[Int], b: Vector[Int]): Int = {
    /*
    var answer = 0
    for(i<- 0 until a.length) answer += a(i)*b(i)
    return answer
    함수형 코딩이 아님
     */
    (for(i<-0 until a.length) yield a(i)*b(i)).sum
  }
}
