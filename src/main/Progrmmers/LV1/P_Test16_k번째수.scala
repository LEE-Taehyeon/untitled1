package LV1

class P_Test16_k번째수 {
  def solution(array: Vector[Int], commands: Vector[Vector[Int]]): Vector[Int] = {
    /*
    var ans = new Vector[Int](commands.size)
    for(i<-0 until commands.size){
      val arr = for(j<-commands(i)(0) - 1 until commands(i)(1)) yield array(j)
      val arrSort = arr.sortWith(_ < _)
      val kNum = arrSort(commands(i)(2)-1)

      //ans(i) = kNum
      println(kNum)
    }
    return Vector[Int]()
    */
    for (c <- commands)
      yield array.slice(c(0)-1, c(1)).sorted.toVector(c(2)-1)
  }
}
