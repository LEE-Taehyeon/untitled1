package LV1

class P_Test19_콜라츠추측 {
  var cnt = 0
  def solution(num: Double): Double = {
    if(cnt>500) -1
    else if(num==1) cnt
    else {
      if(num%2==0){
        cnt+=1
        solution(num/2)
      } else {
        cnt+=1
        solution(3*num+1)
      }
    }
  }
  /*
  //var이 없는 버젼(위의 코드와 동일한 루틴)
  def collaz(num:Double, cnt:Int):Double={
    if(cnt>500) -1
    else if(num==1) cnt
    else {
      if(num%2==0) collaz(num/2, cnt+1)
      else collaz(3*num+1, cnt+1)
    }
  }
  collaz(num, 0)
   */
}
