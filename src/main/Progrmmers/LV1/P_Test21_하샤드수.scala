package LV1

class P_Test21_하샤드수 {
  def solution(x: Int): Boolean = {
    //if(x%x.toString.map(_.toInt - '0').sum==0) true else false
    x%x.toString.map(_.toInt - '0').sum==0
  }
}
