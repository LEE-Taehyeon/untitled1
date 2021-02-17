package LV1

class P_Test23_x만큼간격이있는n개의숫자 {
  def solution(x: Int, n: Int): Vector[Long] = {
    (for(i<-1 to n) yield x*i.toLong).toVector
  }
}
