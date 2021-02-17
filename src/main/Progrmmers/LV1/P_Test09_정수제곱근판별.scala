package LV1

class P_Test09_정수제곱근판별 {
  def solution(n: Long): Long = {
    if(scala.math.sqrt(n).isValidInt){
      return scala.math.pow(scala.math.sqrt(n)+1, 2).toLong
    }
    return -1
  }
}
