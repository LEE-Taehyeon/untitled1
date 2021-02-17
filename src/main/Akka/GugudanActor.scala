import akka.actor.{ Actor, ActorSystem, Props }

class GugudanActor extends Actor{
  override def receive: Receive = {
    case x:Int=>println("<-"+x+"단 입니다.->"); for(i<-1 to 9) println(x+" X "+i+" = "+x*i)
    case _ => println("숫자가 아닙니다.")
  }
}

object GugudanActorCreate extends App{
  val actorSystem = ActorSystem("gugudanActorSystem")

  val actor = actorSystem.actorOf(Props[GugudanActor], "gugudanActor")

  for(i<-2 to 9) actor ! i

  actorSystem.terminate()
}