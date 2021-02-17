package LV1

class P_Test17_제일작은수제거하기 {
  def solution(arr: Vector[Int]): Vector[Int] = {
    /*
    if(arr.size==1) Vector(-1)
    else {
      val vecToArr = arr.toBuffer
      vecToArr-=vecToArr.min
      vecToArr.toVector
    }
    메소드를 이용한 풀이
     */
    //가장 작은 원소의 인덱스를 제외한 나머지 인덱스에 해당하는 원소 복사
    if(arr.size==1) Vector(-1)
    else {
      val minValue = arr.min
      val indexVec = for(i<-0 until arr.length if arr(i)!=minValue) yield i
      (for(i<-0 until indexVec.length) yield arr(indexVec(i))).toVector
    }

    //diff메소드 이용
    val ans = arr.diff(Vector(arr.min))
    if(ans.length==0) Vector(-1)
    else ans


    /*
    //filter메소드 이용 - 매우 오래걸림
    if(arr.length==1) Vector(-1)
    else arr.filter(x=>x!=arr.min)
     */
  }
}
