import akka.actor.{ Actor, ActorSystem, Props }

//변수값을 이용한 패턴매칭 Actor생성
class VariableActor(val value:String) extends Actor{
  override def receive: Receive = {
    case `value` => println(s"""전달된 문자는 String 타입의 "${value}" 입니다.""")
    case _ => println("잘못된 입력입니다.")
  }
}

object VariableActorCreate extends App{
  val actorSystem = ActorSystem("variableActorSystem")
  val actor = actorSystem.actorOf(Props(new VariableActor("만나서 반가워")), "variableActor")

  actor ! "안녕"
  actor ! "만나서 반가워"

  actorSystem.terminate()
}