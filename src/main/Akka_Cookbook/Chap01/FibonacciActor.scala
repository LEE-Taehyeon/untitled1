package Chap01

import akka.actor.{Actor, ActorSystem, Props}

class FibonacciActor extends Actor{
  override def receive: Receive = {
    case num:Int =>
      val fibonacciNumber = fib(num)
      println(fibonacciNumber)
  }
  def fib(n:Int):Int = n match {
    case 0 | 1 => n
    case _ => fib(n-1) + fib(n-2)
  }
}

object FibonacciActorCreate extends App{
  val actorSystem = ActorSystem("fibonacciActorSystem")

  val actor = actorSystem.actorOf(Props[FibonacciActor], "fibonacciActor")

  actor ! 6

  // 액터 시스템 종료
  actorSystem.terminate()
}