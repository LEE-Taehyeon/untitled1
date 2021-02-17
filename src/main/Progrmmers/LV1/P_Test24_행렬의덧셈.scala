package LV1

class P_Test24_행렬의덧셈 {
  def solution(arr1: Vector[Vector[Int]], arr2: Vector[Vector[Int]]): Vector[Vector[Int]] = {
    arr1.zipWithIndex.map(each1=>each1._1.zipWithIndex.map(each2=>each2._1+arr2(each1._2)(each2._2)))

    /*
    for {
      (a1, a2) <- arr1.zip(arr2)
      temp = for ((aa1, aa2) <- a1.zip(a2)) yield (aa1 + aa2)
    } yield (temp)
     */
  }
}
