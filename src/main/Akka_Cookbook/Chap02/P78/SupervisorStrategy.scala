package Chap02.P78

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props, StopChild}


/*
  장애 허용 모델을 구현하는 OneForOneStrategy 를 배운다.
  OneForOneStrategy 클래스는 형제를 제외한 오직 고장 난 자식만 재시작, 재개, 상위 액터에 보고한다.
  감독 전략을 지정하지 않으면 OneForOneStrategy 가 기본전략이 된다.
  OneForOneStrategy 클래스는 액터가 서로간에 의존적이지 않으며, 각각 하나의 작업을 책임지고 액터 하나가 고장 나더라도 다른것에 영향을 주지 않을 때 유용하다.
 */

class Printer extends Actor{
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Printer : I am restarting because of ArithmeticException")
  }
  override def receive: Receive = {
    case msg:String => println(s"Printer $msg")
    case msg:Int => 1 / 0
  }
}

class IntAdder extends Actor {
  var x = 0
  override def receive: Receive = {
    case msg:Int => x = x + msg
      println(s"IntAdder : sum is $x")
    case msg:String => throw new IllegalArgumentException
  }

  override def postStop(): Unit = {
    println("IntAdder : I am getting stopped because I got a string message")
  }
}

class SupervisorStrategy extends Actor{
  import scala.concurrent.duration._
  val second: Duration = Duration.create(1, "minute")

  /*
    maxNrRetries - 몇 번의 재시도 후 종료시키는 전략
    withinTimeRange - 일정한 식나이 흐를 때까지만 재시도 하는 전략
    제한시간이나 횟수 안에 문제를 해결할 수 없다면 오류가 위로 전달된다.
   */
  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = second){
    case _: ArithmeticException => Restart
    case _: NullPointerException => Resume
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }

  val printer = context.actorOf(Props[Printer])
  val intAdder = context.actorOf(Props[IntAdder])
  override def receive: Receive = {
    case "Start" => printer ! "Hello printer"
      printer ! 10
      intAdder ! 10
      intAdder ! 10
      //intAdder ! "Hello int adder"
  }
}

object SupervisorStrategyApp extends App{
  val actorSystem = ActorSystem("Supervisor")
  actorSystem.actorOf(Props[SupervisorStrategy]) ! "Start"
}
/*
  동일한 슈퍼바이저 아래 IntAdder 와 Printer 두 액터를 만들었다. 슈퍼바이저는 자식에게 OneForOneStrategy 를 지정하므로,
  다른 자식을 제외하고 문제가 생긴 것만 슈퍼바이저에 의해 재시작된다.
 */