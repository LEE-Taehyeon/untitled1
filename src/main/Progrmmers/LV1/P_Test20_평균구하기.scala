package LV1

class P_Test20_평균구하기 {
  def solution(arr: Vector[Int]): Double = {
    arr.sum/arr.length.toDouble
    //arr.foldLeft(0.0)(_+_)/arr.length
  }
}
