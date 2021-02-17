import akka.actor.{ Actor, ActorSystem, Props }

//보내는 메세지의 사칙연산 기호에 맞게 결과값을 출력하는 actor 만들기
class OperatorActor extends Actor{
  override def receive: Receive = {
    case (num1:Int, num2:Int, "+") => println(s"sum of $num1 and $num2 is ${num1+num2}")
    case (num1:Int, num2:Int, "-") => println(s"minus of $num1 and $num2 is ${num1-num2}")
    case (num1:Int, num2:Int, "*") => println(s"multiply of $num1 and $num2 is ${num1*num2}")
    case (num1:Int, num2:Int, "/") => println(s"divisor of $num1 and $num2 is ${Math.round((num1/(num2.toDouble)*10))/10.0}")
    case _ => println("wrong formation")
  }
}

object OperatorActorCreate extends App{
  val actorSystem = ActorSystem("operatorActorSystem")
  val actor = actorSystem.actorOf(Props[OperatorActor], "operatorActor")

  actor ! (5, 7, "-")
  actor ! (26, 3, "/")
  actor ! (9, 4, "+")
  actor ! (4, 13, "*")
  actor ! (3, 5, "=")

  actorSystem.terminate()
}
