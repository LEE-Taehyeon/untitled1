package LV1

class P_Test12_수박수박수 {
  def solution(n: Int): String = {
    //if(n%2==0) "수박" * (n/2) else "수박" * (n/2) + "수"
    (for(i<-0 to n) yield if(i%2==1) "수" else "박").mkString("")//.mkString 과 같다.(괄호 없는)
    //mkString이 없으면 yield에 의해서 Vector로 생성
  }
}
