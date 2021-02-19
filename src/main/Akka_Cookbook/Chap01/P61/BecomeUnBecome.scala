package Chap01.P61

import akka.actor.{Props, ActorSystem, Actor}

class BecomeUnBecome {}


/**
 * 어떤 상황에서는 액터가 상태에 따라 행위를 바꾸기를 원하는 때가 있다.
  즉, 액터가 메세지를 수신한 후(받은 후) 상태가 바뀌거나 전환되면 메세지 처리 방법이 바뀌는 경우가 있다는 뜻이다.
 */
object BecomeUnBecomeApp extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val becomeUnBecome = actorSystem.actorOf(Props[BecomeUnBecomeActor])
  becomeUnBecome ! true
  becomeUnBecome ! "Hello how are you?"
  becomeUnBecome ! false
  becomeUnBecome ! 1100
  becomeUnBecome ! true
  becomeUnBecome ! "What do u do?"
}

/*
  상태가 참인지 거짓인지에 따라 행위를 바꾸는 액터 정의

  1) context.become() : 액터의 behavior 를 바꾸는 메소드
 */
class BecomeUnBecomeActor extends Actor {
  def receive: Receive = {
    case true => context.become(isStateTrue)
    case false => context.become(isStateFalse)
    case _ => println("don't know what you want to say !! ")
  }


  // 참일 경우, msg 가 String 일 때 msg 를 출력
  def isStateTrue: Receive  = {
    case msg : String => println(s"$msg")
    case false => context.become(isStateFalse)
  }

  // 거짓일 경우, msg 가 Int 일 때 msg 를 출력
  def isStateFalse: Receive  = {
    case msg : Int => println(s"$msg")
    case true =>  context.become(isStateTrue)
  }
}