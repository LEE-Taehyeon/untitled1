package Chap02.P71

import akka.actor.{Actor, ActorSystem, Props}

class ParentChild {}

/*
  액터의 자식액터를 만드는 방법
  : 아카는 액터를 나무와 같은 계층구조로 만들며, 이 방식을 권장한다.
  이와 같은 방식을 따름으로써, 액터의 장애를 부모가 처리하게 하여 다룰 수 있다.
 */

case object CreateChild
case class Greet(msg:String)

class ChildActor extends Actor{
  override def receive: Receive = {
    case Greet(msg) => println(s"My parent[${self.path.parent}] greeted to me [${self.path}] $msg")
  }
}

class ParentActor extends Actor{
  override def receive: Receive = {
    case CreateChild =>
      val child = context.actorOf(Props[ChildActor], "child")
      child ! Greet("Hello Child")
  }
}

object ParentChild extends App{
  val actorSystem = ActorSystem("Supervision")
  val parent = actorSystem.actorOf(Props[ParentActor], "parent")
  parent ! CreateChild
}
/*
  부모 액터는 context.actorOf 를 사용해 자식액터를 만든다는 것을 알 수 있다. 이 메소드는 부모액터 아래 자식액터를 만든다.
 */