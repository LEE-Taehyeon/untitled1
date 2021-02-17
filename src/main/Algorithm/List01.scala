object List01 extends App {
  //List연산
  //1) :: - 리스트 앞에 요소추가
  println(" :: - 리스트 앞에 요소추가 : " + (1::List(2, 3)))//1+:List(2,3)과 같

  //2) :+ - 리스트 뒤에 요소추가
  println(" :+ - 리스트 뒤에 요소추가 : " + (List(1,2):+3))

  println()
  //책p161 예제함고
  //모든 음의 값을 0으로 만드는
  println("<--리스트 원소를 변경하는-->")
  val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
  var cur = lst


  while(cur!=Nil){
    if(cur.elem<0) cur.elem=0
    cur=cur.next
  }
  println(lst)

  //매 두번째 원소를 제거하는
  var cur2 = lst
  while(cur2!=Nil && cur2.next!=Nil){
    cur2.next = cur2.next.next
    cur2 = cur2.next
  }
  println(lst)

  println()
  //원소들 추가, 제거하는 연산자
  val list1 = Set(1,2,3,4,5)
  val list2 = Set(1,3,5,7,9)
  val list3 = Set(6,7,8,9,10)

  println("<--원소들 추가, 제거하는 연산자-->")
  println(list1--list2)

  println()

  //함수 매핑
  println("<--함수 매핑-->")
  val names = List("Peter", "Jane", "Paul", "Salah")
  println(names.map(_.toUpperCase()))
  //println(names.map(_))



  /*
  각 문자열의 i번째 요소만 대문자로 변경하여 List로 리턴하는 방법 - ???????????????
  val namesUpper = for(name<-names) yield name(2).toUpper
  println(namesUpper)
  */
  println("<--List 돌면서 각 요소의 i번째 철자를 대문자로 변경하는 함-->")
  println(iUpper(3, names))
  def iUpper(i:Int, l:List[String]) = {
    for(k<-l) yield k.substring(0,i)+k(i).toUpper+k.substring(i+1,k.length)
  }

  def ulCase(s:String) = Vector(s.toUpperCase(), s.toLowerCase())
  println(names.map(ulCase))

  println()



  //Zipping(지핑)
  println("<--Zipping-->")
  val prices = List(10.0, 20.0, 9.95)
  val quantities = List(3, 5, 2)
  val pZipQ = prices zip quantities

  println("price zip quantities : " + pZipQ)
  println("price * quantities : " + pZipQ.map(p=>p._1*p._2))

  println(List(10, 20, 35, 40) zipAll(List(2, 4), 500, 1))
  println()



}
