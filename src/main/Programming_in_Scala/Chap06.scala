class Chap06 {

}
object chap06 extends App{

}

//분수 클래스 만들기
class Rational(n:Int, d:Int){//필드 없이 기본생성자로만 객체를 생성하면 외부에서 해당 객체의 파라미터에 접근할 수 없다. ex)rational.n (X:접근불가)
  //선결 조건 확인
  //require문은 해당 조건이 참이면 정상적으로 require문을 종료시키고
  //           해당 조건이 거짓이면 IllegalArgumentException 예외를 발생해 객체의 생성을 막는다.
  require(d!=0)

  //분모, 분자를 최대 공약수로 만들기 위한 작업
  private val g = gcd(n.abs, d.abs)//private이므로 내부에서만 접근가능, 외부에서 접근불가능
  //add메소드를 만들기 위한 필드
  val numer:Int=n/g//외부에서 접근할 수 있게 필드로 생성했다.
  val denom = d/g

  //재귀함수는 리턴타입을 명시해야한다.
  private def gcd(a: Int, b: Int):Int = if(b==0) a else gcd(b, a%b)//private이므로 내부에서만 접근가능, 외부에서 접근불가능


  //보조 생성자 -> 이렇게 작성하면 val a = new Rational(4) 작성시 Rational = 4/1 로 출력된다.
  def this(n:Int) = this(n, 1)


  //분모 : d, 분자 : n
  //println(n + "/"+ d)
  override def toString: String = numer + "/"+ denom
  def +(that:Rational):Rational= new Rational(numer*that.denom + that.numer*denom, denom*that.denom)
  def -(that:Rational):Rational = new Rational(numer*that.denom - that.numer*denom, denom*that.denom)
  def *(that:Rational):Rational= new Rational(numer*that.numer, denom*that.denom)
  def /(that:Rational):Rational= new Rational(numer*that.denom, denom*that.numer)

  //메소드 오버로드
  //분수와 정수의 연산을 편하게 하기위함;메소드를 오버로드 하지 않으면 a * 2로 사용할 수 없고 a * new Rational(2)로 사용해야한다.
  def +(n:Int):Rational= new Rational(denom*n+numer, denom)
  def -(n:Int):Rational = new Rational(numer-denom*n, denom)
  def *(n:Int):Rational= new Rational(numer*n, denom)
  def /(n:Int):Rational= new Rational(numer, denom*n)
  // implicit def intToRational(x:Int) = new Rational(x) 를 작성해주면 2 * a 같은 경우도 가능하다.

  //비교하려는 값보다 더 작은가? - 작으면 true, 크면 false
  def lessThan(that:Rational) = this.numer * that.denom < this.denom * that.numer
  //더 큰가?
  def lagerThan(that:Rational) = this.numer * that.denom > this.denom * that.numer

  def max(that:Rational) = if(this.lessThan(that)) that else this
  def min(that:Rational) = if(this.lagerThan(that)) this else that


}