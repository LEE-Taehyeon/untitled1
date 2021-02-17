class StringFormat {

}
object StringFormat extends App{
  //왜 Double.box()로 감싸야하는거지?????
  val pie = 3.141592
  val pie1 = String.format("%.3f", Double.box(pie))

  println(pie1)
}
