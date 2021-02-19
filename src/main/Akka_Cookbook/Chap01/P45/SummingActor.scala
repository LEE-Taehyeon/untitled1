package Chap01.P45

import akka.actor.{Actor, ActorSystem, Props}


/*
  액터는 다른 액터와 통신하는데 쓰는 말하기(tell) : ! , 요청하기(ask) : ? 같은 메소드를 가진다.
  ! 는 발사 후 망각형이며
  ? 는 미래에 액터로부터 올 것이라는 뜻의 퓨처(Future)를 반환한다.
  액터에 메세지를 송신하자마자(보내자마자) 액터는 메세지를 수신하고(받고), 스레드 풀로부터 기본적인 자바 스레드를 가져오고,
  작동시키고, 스레드를 해제한다. 액터는 현재 실행 스레드를 절대 막지 않으므로 비동기적이라고 할 수 있다.
 */
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
