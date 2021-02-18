package Chap17

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.immutable.{TreeSet, TreeMap}

class collection {}

object collection extends App{
  // 17.1 시퀀스 - 시퀀스(sequence) 타입은 순서가 정해진 데이터 그룹을 가지고 작업할 수 있게 해준다.
  //             원소에 순서가 있기 때문에, 첫번째 원소, 두번째 원소, 103번째 원소등을 요구 할 수 있다.

  // 1) 리스트 - Chap16
  //           ( https://blog.naver.com/merongvvvv/222247162232 참고 )

  // 2) 배열 - 원소의 시퀀스를 저장하며, 임의의 위치에 있는 원소에 효율적으로 접근하게 해준다.
  //          0을 기준으로 하는 인덱스를 사용해 원소를 읽거나 변경할 수 있다. 길이고
  // 배열 초기화 방법
  val fiveInts = new Array[Int](5) // 크기가 5이고 원소가 모두 0인 배열
  val fiveToOne = Array(5,4,3,2,1) // Array(5,4,3,2,1)

  // 3) 리스트버퍼 - List 클래스는 리스트이 앞쪽에 대해서는 빠른 접근을 제공하지만, 끝쪽에 대해서는 그렇지 않다.
  //              그러므로 리스트의 끝부분에 원소를 추가하려면 리스트를 뒤집어(reverse) 원소를 앞에 추가한 후, 다시 뒤집어야한다.
  //              이때, reverse 연산을 피할 수 있는 방법은 ListBuffer 를 사용하는 것이다.
  //              ListBuffer 는 변경 가는한 객체(scala.collection.mutable)이다.
  //              append(+=)와 prepend(+=:)연산을 통해 원소를 뒤와 앞에 추가할 수 있다.
  val listBuf = new ListBuffer[Int]
  listBuf += 1
  println(listBuf) // ListBuffer(1) 리턴
  listBuf += 3
  println(listBuf) // ListBuffer(1, 3) 리턴
  2 +=: listBuf
  println(listBuf) // ListBuffer(2, 1, 3) 리턴

  // 4) 배열버퍼 - ArrayBuffer 는 끝부분과 시작부분에 원소를 추가하거나 삭제할 수 있다는 점만 제외하면 배열과 같다.정
  //            새 원소를 추가하거나 삭제하는데는 평균적으로 상수시간이 걸리나, 때때로 버퍼의 내용을 저장하기 위해 새로운 배열을 할당해야하기 때문에
  //            종종 선형시간이 걸린다. 가변 길이
  val arrayBuf = new ArrayBuffer[Int]()
  arrayBuf += 12
  println(arrayBuf) // ArrayBuffer(12) 리턴
  arrayBuf += 29
  println(arrayBuf) // ArrayBuffer(12, 29) 리턴
  3 +=: arrayBuf
  println(arrayBuf) // ArrayBuffer(3, 12, 29) 리턴


  // 17.2 집합과 맵
  // 1) 집합(Set) - 중복을 배제하기 때문에, 각기 다른 값만 정확히 한 번 나타난다.
  val text = "See Spot run. Run, spot. Run"
  val wordsArray = text.split("[ !,.]+") // Array(See, Spot, run, spot, Run) 리턴
  //for(word<-wordsArray) println(word)

  val words = mutable.Set.empty[String]
  for(word<-wordsArray) words += word.toLowerCase
  println(words) // Set(see, spot, run) 리턴

  // 2) 맵
  val mutableMap = mutable.Map.empty[String, Int]
  mutableMap("hello") = 5
  mutableMap("hi") = 2
  println(mutableMap) // Map(hi->2, hello->5) 리턴

  val immutableMap = Map("my"->2, "name"->4, "is"->2, "Salah"->5)
  println(immutableMap) // Map("my"->2, "name"->4, "is"->2, "Salah"->5) 리턴

  // 3) 정렬된 집합과 맵 - 때때로 정해진 순서대로 원소를 반환하는 이터레이터를 제공하는 맵이나 집합이 필요하다.
  //                   이를 위해 스칼라는 SortedSet, SortedMap 트레이트가 있다. 이 두 트레이트의 구현은 각각 TreeSet, TreeMap 클래스다.
  val ts = TreeSet(9, 5, 3, 6, 2, 4, 1, 6, 8, 7) // immutable
  println(ts) // TreeSet(1, 2, 3, 4, 5, 6, 7, 8, 9) 리턴
  val cs = TreeSet('d', 'w', 'a')
  println(cs) // TreeSet('a', 'd', 'w') 리턴

  val tm = TreeMap(3->'s', 1->'a', 9->'w', 4->'w', 3->'e') // immutable
  println(tm) // TreeMap(1->a, 3->e, 4->w, 9->w) 리턴 / 중복된 키는 마지막에 들어온 키-값 이 저장됨


  // 17.4 컬렉션 초기화
  // 1) 변경 가능한 <-> 변경 불가능한 사이의 변환
  // {1} 변경 불가능한 -> 변경 가능한
  val treeSet = TreeSet("blue", "green", "red", "yellow") // immutable
  // treeSet += "black" -> ERROR : treeSet 이 immutable 이기 때문에
  val mutableSet = mutable.Set.empty ++= treeSet
  println(mutableSet) // Set(red, blue, green, yellow) 리턴 / mutable
  mutableSet += "white"
  println(mutableSet) // Set(red, white, blue, green, yellow) 리턴 / mutable

  // {2} 변경 가능한 -> 변경 불가능한
  val immutableSet = Set.empty ++ mutableSet
  println(immutableSet) // Set(blue, green, yellow, white, red) 리턴 / immutable

}
