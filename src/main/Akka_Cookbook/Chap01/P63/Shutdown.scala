package Chap01.P63

import akka.actor.{PoisonPill, Props, ActorSystem, Actor}

class Shutdown {}


/**
 * 액터가 모든 메세지를 처ㅣ했거나 앱이 정지되면 액터도 당연히 잘 정지되어야 한다.
 */
// 액터를 중단시키는 데는 두 가지 방법이 있다.
// 1) PoisonPill(독약) 사용하기 : PoisonPill 은 메일박스에 이미 대기된 모든 메세지 이후에 처리되는 내장 메세지이다.
// 2) context.self(actorRef) 사용하기 : 기본적으로 액터를 순차적으로 정지시킬 때 사용한다. 자식 액터부터 중단시키고, 부모액터, 액터시스템 순으로
//                                    진행해 최상위 액터를 중단시킨다.
object ShutdownApp extends App{
  val actorSystem = ActorSystem("HelloAkka")
  val shutdownActor1 = actorSystem.actorOf(Props[ShutdownActor], "shutdownActor1")
  shutdownActor1 ! "hello1"
  shutdownActor1 ! PoisonPill
  shutdownActor1 ! "Are you there?"

  val shutdownActor2 = actorSystem.actorOf(Props[ShutdownActor], "shutdownActor2")
  shutdownActor2 ! "hello2"
  shutdownActor2 ! Stop
  shutdownActor2 ! "Are you there?"

}

class ShutdownActor extends Actor {
  override def receive: Receive = {
    case msg:String => println(s"$msg")
    case Stop => context.stop(self)
  }
}

case object Stop{}

