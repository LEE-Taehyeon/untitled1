package Chap02.P81

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, ActorSystem, AllForOneStrategy, Props}

class AllForOneStrategy {}

/*
  AllForOneStrategy 는 슈퍼바이저 아래의 액터에 장애가 발생하면 감독 하의 모든 자식에 전략을 적용한다는 의미이다.
 */

case class Add(a:Int, b:Int)
case class Sub(a:Int, b:Int)
case class Div(a:Int, b:Int)

class Calculator(printer:ActorRef) extends Actor{
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Calculator : I am restarting because of ArithmeticException")
  }
  override def receive: Receive = {
    case Add(a:Int ,b:Int) => printer ! s"sum is ${a + b}"
    case Sub(a:Int ,b:Int) => printer ! s"sub is ${a - b}"
    case Div(a:Int ,b:Int) => printer ! s"div is ${a / b}"
  }
}

class ResultPrinter extends Actor{
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = println("Printer : I am restarting as well")
  override def receive: Receive = {
    case msg => println(msg)
  }
}

class AllForOneStrategySupervisor extends Actor{
  import scala.concurrent.duration._
  val second: Duration = Duration.create(1, "seconds")

  override val supervisorStrategy = AllForOneStrategy(maxNrOfRetries = 10, withinTimeRange = second){
    case _: ArithmeticException => Restart
    case _: NullPointerException => Resume
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }
  val printer = context.actorOf(Props[ResultPrinter])
  val calculator = context.actorOf(Props(classOf[Calculator], printer))

  override def receive: Receive = {
    case "Start" => calculator ! Add(10, 12)
      calculator ! Sub(12, 10)
      calculator ! Div(5, 2)
      calculator ! Div(5, 0)
  }
}

object AllForOneStrategyApp extends App{
  val actorSystem = ActorSystem("Hello-akka")
  val supervisor = actorSystem.actorOf(Props[AllForOneStrategySupervisor], "supervisor")

  supervisor ! "Start"
}
/*
  Calculator 에 예외가 발생하면 AllForOneStrategy 로 인해 두 액터 모두 재시작된다.
 */