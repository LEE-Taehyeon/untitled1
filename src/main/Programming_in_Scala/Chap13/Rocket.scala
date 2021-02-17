//P297
package Chap13

class Rocket{
  import Rocket.fuel
  private def conGoHomeAgain = fuel > 20
}
object Rocket extends App {
  private def fuel = 30


  def chooseStrategy(rocket: Rocket) = {
    if(rocket.conGoHomeAgain) goHome()
    else pickAStar()
  }

  chooseStrategy(new Rocket)

  def goHome() = println("goHome")
  def pickAStar() = println("pickAStar")
}