package Chap15

class OptionEx{

}

object OptionEx extends App{
  def show(x:Option[String]) = x match {
    case Some(s) => s//이렇게 하면 그냥 s 값만 출력 / Some(_) => x :Some(x) 출력
    case None => "?"
  }

  val cap = Map("France"->"Paris", "Korea"->"Seoul", "Japen"->"Tokyo")
  println(show(cap get "France"))
}