package LV1

class P_Test08_문자열내마음대로정렬하기 {
  def solution(strings:Vector[String], n:Int):Vector[String]={
    //
    strings.sortBy(i => (i(n), i))

    /*
    val stringsSort = strings.sortWith((s, t) =>
      if(s(n) == t(n)){
        s<t
      }else{
        s(n) < t(n)
      }
    )

    stringsSort
    */

    /*
    strings.sortWith((s, t)=>{
      if(s(n)==t(n)) {
        s < t
      }else{
       s(n)<t(n)
      }
    })
     */
  }
}
