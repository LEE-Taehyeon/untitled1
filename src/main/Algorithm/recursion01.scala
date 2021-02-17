//재귀함수 : 팩토리얼
object recursion01 extends App{

  //팩토리얼 구현방법1 : 일반적인 팩토리얼
  def iFact(num: Int): Int = {
    var answer = 1
    for (i <- 1 to num) answer *= i
    answer
  }

  //팩토리얼 구현방법2 : 재귀함수를 이용한 팩토리얼
  def iFactRecursion(num: BigInt): BigInt = {
    var answer = 1
    if (num == 1) 1 else num * iFactRecursion(num - 1)
  }

  //팩토리얼 구현방법3 : 재귀함수+내부함수 팩토리얼 -> 구현방법2에서 스택오버플로우를 방지할 수 있는 방법
  def iFactRecurInnerFunc(num:BigInt):BigInt = {
    def innerFunc(num:BigInt, acc:BigInt):BigInt={
      if(num==1) acc else innerFunc(num-1, num*acc)
    }
    innerFunc(num, acc=1)
  }

  println(iFact(10))
  println(iFactRecursion(10))
  println(iFactRecurInnerFunc(10))
}
