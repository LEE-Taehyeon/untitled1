class Chap03 {

}
object chap03 extends App{
  //완전한 함수형이 아니다
  def printArgs(args:Array[String]):Unit={
    args.foreach(println)
  }

  //위의 작성된 코드의 완전한 함수형.ver
  def printArgsCompleteFunction(args:Array[String]) = args.mkString("\n")

}