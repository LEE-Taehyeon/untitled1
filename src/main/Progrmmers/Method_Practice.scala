class Method_Practice {

}

object Method_Practice extends App{
  //LV1. k번째 수
  val arr = Array(1,2,3,4,5,6,7)
  println(arr.slice(3, 6))//slice(from, until)
  println(arr.slice(0, 6).mkString("Array(", ", ", ")"))//보기 편하게


}
