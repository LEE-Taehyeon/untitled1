package Chap16

class list {}

// List(리스트) - 변경 불가능한 Seq
// 특징 - 1) List는 앞부분에 빠르게 원소를 추가하거나 삭제할 수 있다.
//       2) 그러나 순차적으로 따라가야만 하기 때문에 임의의 위치ㅣ에 접근할 때는 빠르지 않다.
object list extends App{
  val fruit = List("apple", "orange", "pear", "watermelon")
  val nums = List(1,2,3,4,5,6,7,8,9)
  val list = List()

  // 1. head, tail, isEmpty
  // head 는 어떤 리스트의 첫번째 원소를 반환한다.
  // tail 은 어떤 리스트의 첫번째 원소를 제외한 나머지 원소로 이루어진 리스트다.
  // isEmpty 는 리스트가 비어있다면 true를 리턴한다.
  println(fruit.head) // apple 리턴
  println(fruit.tail) // List(orange, pear, watermelon) 리턴
  println(list.isEmpty) // true 리턴

  // 2. 리스트 패턴
  val List(a,b,c,d) = fruit
  println(a) // apple 리턴
  println(b) // orange 리턴
  println(c) // pear 리턴
  println(d) // watermelon 리턴

  // 3. List클래스의 1차 메소드
  // 1) 두 리스트 연결하기 - :::
  println(List(1,2,3):::List(4,5,6,7)) // List(1,2,3,4,5,6,7) 리턴

  // 2) 리스트 길이 구하기 - List().length
  println(fruit.length)

  // 3) init - 마지막 원소를 제외한 모든 원소를 포함한 리스트 리턴
  //    last - 비어있지 않은 리스트의 마지막 원소 리턴
  println(fruit.init) // List(apple, orange, pear) 리턴
  println(fruit.last) // watermelon 리턴

  // 4) reverse - 리스트 뒤집기
  println(fruit.reverse) // List(watermelon, pear, orange, apple) 리턴

  // 5) drop - List() drop n : 첫번째에서 n번 째까지 원소를 제외한 List() 리턴
  //    take - List() take n : 첫번째에서 n번 째까지의 List() 리턴
  //    splitAt - List() splitAt n : 주어진 인덱스 위치에서 리스트를 분할해서, 두 리스트가 들어있는 순서쌍을 리턴
  println(nums drop 4) // List(5,6,7,8,9) 리턴
  println(nums take 4) // List(1,2,3,4) 리턴
  println(nums splitAt 4) // List(1,2,3,4), List(5,6,7,8,9) 리턴

  // 6) apply - 원소 선택하기
  //    indices - 리스트에서 유효한 모든 인덱스의 리스트 리턴
  println(fruit(2)) // pear 리턴
  println(fruit.indices) // Range(0,1,2,3) 리턴

  // 7) zip - 순서쌍으로 묶기
  //    unzip - 묶은거 풀기
  println(fruit zip nums) // Vector((apple, 1), (orange, 2), (pear, 3), (watermelon, 4)) 리턴

  // 8) toString, mkString - 리스트 출력하기
  // 9) iterator, toArray, copyToArray - 리스트 변환하기

  // 4. List 클래스의 고차 메소드
  // 1) map, flatmap, foreach - 리스트 매핑
  // 2) filter, partition, find, takeWhile, dropWhile, span - 리스트 걸러내기
  println(List(1,2,3,4,5) filter(_%2==0)) // List(2,4) 리턴 / filter : 조건에 맞는 원소로만 조합된 리스트 리턴
  println(List(1,2,3,4,5) partition (_%2==0)) // List(2,4), List(1,3,5) 리턴 / partition : 조건에 맞는 리스트, 아닌 리스트 구분지어 리턴
  println(List(1,2,3,4,5,6,7,8) find (_%2==0)) // Some(2) 리턴 / find : 조건에 맞는 최초의 원소만 리턴
  println(List(1,2,3,4,5,-6,7,8) takeWhile (_>0))
  println(List(1,2,3,4,5,-6,7,8) dropWhile (_>0))
  println(List(1,2,3,4,5,-6,7,8) span (_>0))

  // 3) forall, exits - 리스트 전체에 대한 술어
  // forall - 모든 원소가 참이어야 true 리턴
  // exits - 하나라도 참이면 true 리턴


}