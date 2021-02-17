class Chap04 {
  //비공개 필드는 외부에서 접근할 수 없다.
  //private로 선언한 필드는 클래스 내부에서만 접근이 가능하다.
  private var sumPri = 0
  var sum = 0

  def increaseNum(num:Int) = sumPri+=num
  def showNum() = println(sumPri)
}
