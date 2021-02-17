package LV1

class P_Test11_문자열내림차순으로정렬하기 {
  def solution(s: String): String = {
    //s.toVector.sorted.reverse.mkString("")
    s.sorted.reverse
    // s.sortWith(_.toInt>_.toInt).mkString("")
  }
}
