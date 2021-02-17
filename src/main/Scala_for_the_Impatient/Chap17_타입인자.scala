import java.lang.Comparable

//Scala_for_the_Impatient
//Chapter 17. 타입인자
class Chap17_타입인자 {

}

object chap17 extends App{


}
//타입변수에 대한 바운드
class Pair[T <: Comparable[T]](val first:T, val second:T){//<:Comparable[T]를 추가해주어야 한다.
  def smaller = if(first.compareTo(second)<0) first else second
}