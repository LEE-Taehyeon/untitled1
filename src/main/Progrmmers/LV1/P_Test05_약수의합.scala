package LV1

class P_Test05_약수의합 {
  def solution(n: Int): Int = {
    /*
    var sum = 0
    for(i<-1 to n if(n%i==0)) sum+=i
    return sum
    함수형 코딩이 아니다.
     */
    (for(i <- 1 to n if n % i == 0)  yield i).sum  // Vector로 만들고 원소들 합하기
    //(for(i<- 1 to n if n%i==0) yield i).foldLeft(0)(_+_) //위의 sum과 같다.
  }
}
