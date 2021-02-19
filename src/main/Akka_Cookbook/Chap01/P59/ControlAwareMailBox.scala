package Chap01.P59

class ControlAwareMailBox {}


import akka.dispatch.ControlMessage
import akka.actor.{Props, Actor, ActorSystem}

/**
 * 액터가 특정 메세지를 다른 메세지보다 먼저 처리하기를 원하는 상황이 있다.
 */
object ControlAwareMailbox extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val  actor = actorSystem.actorOf(Props[Logger].withDispatcher("control-aware-dispatcher"))

  actor ! "hello"

  actor ! "how are"

  actor ! "you?"

  actor ! MyControlMessage
}

// ControlMessage 를 확장하는 MyControlMessage 오브젝트 생성
// ControlMessage 는 트레이트다. 이 트레이트를 확장하는 메세지는 ControlAwareMailBox 가 우선적으로 다룬.
// ControlAwareMailBox 는 두 개의 큐를 유지해 ControlMessage 를 확장하는 메세지가 우선으로 전달되도록 한다.
case object MyControlMessage extends ControlMessage

class Logger extends Actor {
  def receive = {
    case MyControlMessage => println("Oh, I have to process Control message first")
    case x => println(x.toString)

  }
}