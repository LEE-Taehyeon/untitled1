package LV1

class P_Test07_문자열다루기기본 {
  def solution(s: String): Boolean = {
    /*
    if((s.length!=4 && s.length!=6)) return false
    for(i<-s) if(i.toChar>57) return false
    return true
     */

    if(s.forall(_.isDigit) && List(4,6).contains(s.length)) true
    else false
  }
}
