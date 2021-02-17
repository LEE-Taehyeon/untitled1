package Chap15

class caseClass {

}

abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String, arg:Expr) extends Expr
case class BinOp(operator:String, left:Expr, right: Expr) extends Expr

object caseClass extends App{
  //패턴가드를 사용한 패턴 변경
  def simplifyAdd(e:Expr) = e match {
    case BinOp("+", x, y) if x==y =>
      BinOp("*", x, Number(2))
    case _ => e
  }

  simplifyAdd(BinOp("+", Number(4), Number(4)))

}