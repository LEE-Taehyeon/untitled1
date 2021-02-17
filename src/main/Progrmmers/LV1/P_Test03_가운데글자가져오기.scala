package LV1

class P_Test03_가운데글자가져오기 {
  def solution(s: String): String = {
    s.substring((s.length-1)/2, s.length/2+1)
  }
}