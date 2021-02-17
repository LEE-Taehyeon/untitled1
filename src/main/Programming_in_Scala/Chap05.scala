class Chap05 {

}

object chap05 extends App{
  //raw(로) 문자열
  //  " = \" , ' = \' , \ = \\ 등을 """ """ 안에서는 그냥 사용할 수 있다.
  println("""Welcome to Ultimax 3000.
             Type "HELP" for help.""")
  //다만, 이 경우 중간의 공백까지 포함되어 출력
  //이를 stripMargin을 통해 해결할 수 있다.
  println(
    """Welcom to Ultimax 3000.
      |Type "Help" for help.""".stripMargin)

  //전위 연산자(-,+,!,~)(ex. -2.0, !found, ~0xFF ...)
  //전위 연삱자는 메소드 기호 앞에 unary_가 붙는다.
  //즉, -2.0 은 (2.0).unary_- 이다.
  println(-2.0)
  println((2.0).unary_-)
  //후위 연산자(toLong, toLowerCase ...)
  // . 을 없애고 사용할 수 있다.
  println("string".toUpperCase())
  println("STRING" toLowerCase())

  


}