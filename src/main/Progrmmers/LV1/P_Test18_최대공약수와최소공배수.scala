package LV1

class P_Test18_최대공약수와최소공배수 {
  def solution(n: Int, m: Int): Vector[Int] = {
    def gcd(a:Int, b:Int):Int = {//최대공약수를 구하는 메소드
      if(b==0) a
      else gcd(b, a%b)
    }
    Vector[Int](gcd(n, m), n*m/gcd(n,m))

    /*
    //BigInt 타입에 gcd메소드가 이미 존재
    val a:BigInt = n
    val b:BigInt = m
    Vector(a.gcd(b).toInt, n*m/a.gcd(b).toInt)
     */
  }
}
