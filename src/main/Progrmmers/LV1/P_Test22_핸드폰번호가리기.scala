package LV1

class P_Test22_핸드폰번호가리기 {
  def solution(phone_number: String): String = {
    (for(i<-0 until phone_number.length-4) yield "*").mkString+phone_number.substring(phone_number.length-4)
    "*"*(phone_number.length - 4) + phone_number.substring(phone_number.length - 4, phone_number.length)
    //문자열과 숫자를 곱해서 해당 문자열을 반복한 문자열을 리턴하고 싶을때는
    //문자열이 먼저오도록 작성해야한다.
  }
}
