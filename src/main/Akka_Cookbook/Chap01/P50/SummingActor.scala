package Chap01.P50

import akka.actor.{Actor, ActorSystem, Props}

class SummingActor extends Actor {
  var sum = 0

  override def receive: Receive = {
    case x:Int => sum += x
      println(s"my state as sum is $sum")
    case _ => println("I don't know what are you taking about")
  }
}
object SummingActorCreate extends App{
  //HelloAkka 는 액터시스템의 이름
  val actorSystem = ActorSystem("SummingActorSystem")
  //액터 시스템 내부에 액터를 생성
  val actor = actorSystem.actorOf(Props[SummingActor], "SummingActor")
  println(actor.path)

  while(true){
    Thread.sleep(3000)
    actor ! 1
  }

}
