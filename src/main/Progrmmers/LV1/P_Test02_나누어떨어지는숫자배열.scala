package LV1

class P_Test02_나누어떨어지는숫자배열 {
  def solution(arr: Vector[Int], divisor: Int): Vector[Int] = {
    //val ans = arr.filter(x=>x%divisor==0).sorted
    val ans = arr.filter(_%divisor==0).sorted
    if(ans.isEmpty) Vector(-1) else ans

    /*
    val ans = (for(i<-arr.sorted if(i%divisor==0)) yield i).toVector
    if(ans.size==0) Vector[Int](-1) else ans
     */
  }
}
