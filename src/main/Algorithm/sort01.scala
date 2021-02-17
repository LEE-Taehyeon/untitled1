object sort01 extends App {
  val sort = Vector("sf", "sfd", "esfe")

  //sorted : 단순 숫자나 문자로 정렬하고 싶을 때 사용
  println("--sorted 메소드 : 오름차순으로 정렬, .reverse:내립차순으로 정렬--")
  println(sort.sorted)
  println(sort.sorted.reverse)
  println(sort.reverse)//단순히 배열 뒤집기, 위의 .sorted.reverse와는 완전히 다른것

  println()

  //sortBy() : 정렬기준을 정해서 정렬할 수 있습니다.
  //           예를들어, 문장길이나 리스트 안 클래스에서 정렬 기준되길 원하 멤버 정하거 할 수 있습니다.
  println("sortBy() 메소드 : 정렬기준을 정해서 정렬")
  println(sort.sortBy(s=>0-s.length))

  println()

  //sortWith() : 정렬기준을 직접 정해서 정렬할 수 있습니다.
  println("sortWith() 메소드 : 정렬기준을 직접 정해서 정렬")
  println(sort.sortWith((s1, s2) => {
    if(s1(1)==s2(1)){
      s1.length>s2.length//내림차순
    }else{
      s1(1) < s2(1)
    }
  }))

}
