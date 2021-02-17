object recursion02_List extends App {
  val list = List(1,2,3,4,5)

  //2배 리스트
  def doubleList(xs:List[Int]):List[Int] = {
    if(xs.isEmpty) Nil
    else (xs.head * 2) :: doubleList(xs.tail)
  }

  println(doubleList(list))

  //2배 리스트 패턴매칭
  def doubleListPM(xs:List[Int]):List[Int] = xs match {
    case Nil => Nil
    case x :: tail => (x*2)::doubleListPM(xs.tail)
  }

  println(doubleListPM(list))

  //n배 리스트
  def nTimesList(n:Int)(xs:List[Int]):List[Int]={
    if(xs.isEmpty) Nil
    else (xs.head * n) :: nTimesList(n)(xs.tail)
  }

  println(nTimesList(5)(list))


  //제곱 리스트
  def squareList(xs:List[Int]):List[Int]={
    if(xs.isEmpty) Nil
    else (xs.head*xs.head)::squareList(xs.tail)
  }

  println(squareList(list))

  //n배 리스트, 제곱 리스트 일반화
  def mapIntList(f:Int=>Int)(xs:List[Int]):List[Int]={
    if(xs.isEmpty) Nil
    else f(xs.head)::mapIntList(f)(xs.tail)//f자리에 double함수가 들어간것
    //즉, f(xs.head)::mapIntList(f)(xs.tail) 는 double(xs.head)::mapIntList(f)(xs.tail) 과 같은
  }
  def double(n:Int):Int = n*2
  def square(n:Int):Int = n*n

  println(mapIntList(double)(list))
  println(mapIntList(square)(list))

  //제네릭 타입으로 변경하여 유연성 높이기
  def mapList[T,U](f:T=>U)(xs:List[T]):List[U]={
    if(xs.isEmpty) Nil
    else f(xs.head) :: mapList(f)(xs.tail)
  }

  def upper(c:Char):Char=c.toUpper

  println(mapList(double)(list))
  println(mapList(upper)(List('a', 'b', 'c')))
  println(mapList((n:Int)=>n*n)(list))
  println(mapList((n:Int)=>Math.sqrt(n))(list))

  //그러나 이렇게 함수로 만들지 않아도 스칼라에는 기본API로 함수를 제공
  println("----------------")
  println(list.map(n=>n*2))
  println(list.map(n=>Math.sqrt(n.toDouble)))

  println(list.filter(n=>n%2==0))//()안의 조건에 해당되는 것들로만 list 생성
  println(list.filter(_%2==0))//인자추론 : 위의 코드를 간략화한 것

  println(list.max)
  println(list.exists(n=>n%2==0))//()안의 조건이 만족되는 것이 하나라도 있으면 true 반환
  println(list.reduce((a, b)=>a-b))
  println(list.sum)
  println(list.reduce((a, b)=>a*b))//밑의 product와 같은 것:모든 원소를 다 곱하
  println(list.product)
  println(list.partition(n=>n%2==0))//partition은 ()안의 조건에 맞는것(참)과 틀린것(거짓)으로 나누는 것
  println(list.mkString(","))//결과값의 타입이 String이다
  println(list.zip(List("d","e")))//zip메소드:list의 원소갯수와 zip하려는 리스트의 원소갯수가 같지 않을때는 작은 것으로 zipping실행
  println(List(List(1,3), List(2,4)).flatten)//flatten:안쪽에 있는 리스트를 펼쳐서 하나의 밖의 리스트로 만드는 메소드
  println(list.map(x=>List(x, x*x)))
  println(list.flatMap(x=>List(x, x*x)))//밑에것과 같은, 안쪽에 있는 리스트를 펼쳐서 하나의 밖의 리스트로 만드는
  println(list.map(x=>List(x, x*x)).flatten)


}
