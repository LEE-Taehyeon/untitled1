package LV1

class P_Test10_두정수사이의합 {
  def solution(a: Int, b: Int): Int = {
    val maxNum = if (a > b) a else b
    val minNum = if (a < b) a else b
    var sum = 0

    for (i <- minNum to maxNum) {
      //println(i)
      sum += i
    }

    return sum//함수형 코드 작성이 아니므로 아래의 코드처럼 작성하는 것을 권장

    /*
    if(a<b) (a.toLong to (b.toLong)).sum else (b.toLong to (a.toLong)).sum
     */
  }
}

