package LV1

class P_Test06_자연수뒤집어배열로만들기 {
  def solution(n: Long): Vector[Int] = {
    (for(i<-(n.toString).reverse) yield i.toString.toInt).toVector
    n.toString.map(_.toInt-'0').reverse.toVector
  }
}
