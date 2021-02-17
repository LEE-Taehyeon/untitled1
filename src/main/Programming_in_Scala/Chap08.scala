class Chap08 {

}
object chap08 extends App{
  //반복 파라미터 : 인자 타입부분에 *를 추가하여 길이가 변하는 인자 목록을 함수에 전달할 수 있다.
  def echo(args:String*) = for(arg<-args) println(arg)

  echo("one")
  echo("hello", "world!")

  val arr = Array("What's", "up", "doc?")
  //echo(arr) -> 이렇게 하면 배열 전체를 하나의 인자로 생각하여 에러발생
  echo(arr:_*)//_*를 추가해야 한다.

  //디폴트 인자값
  def hello(front:String="Hello", back:String="nice to meet you") = println(front+" "+back)
  hello(front = "goodbye")//그냥 hello() 로 호출하면 디폴트 값으로 결과값이 나타나고, 해당 인자에 새로운 값을 넣으면 그 값으로 결과값이 나타난다.

}