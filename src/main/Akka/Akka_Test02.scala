import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

// actor에 두개의 숫자를 보내 두 숫자를 더하는 actor
class SumActor extends Actor with ActorLogging{
  override def receive: Receive = {
    case (x:Int, y:Int) => println(s"sum of $x and $y is ${x+y}")
    case _ => println("wrong formation")
    //println으로 했을 때는 두 case 모두 검사
    //log.info로 했을 때는 해당 예제에서 actor ! 4 에 대한 결과값을 출력 안함
  }
}

object SumActorCreate extends App{
  val actorSystem = ActorSystem("sumActorSystem")

  val actor = actorSystem.actorOf(Props[SumActor], "sumActor")

  actor ! (3,6)
  actor ! 4

  actorSystem.terminate()
}
