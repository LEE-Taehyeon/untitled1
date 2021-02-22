package Chap02.P76

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.util.Random

class SendMessageToChild {}

/*
  액터에게 메세지 보내고 응답 모으기
  : 부모가 자식에게 메세지를 송신하고 응답을 모으는 방법을 배운다.
 */

case class DoubleValue(x:Int)
case object CreateChild
case object Send
case class Response(x:Int)

class DoubleActor extends Actor{
  override def receive: Receive = {
    case DoubleValue(number) =>
      println(s"${self.path.name} Got the number $number")
      sender ! Response(number * 2)
  }
}

class ParentActor extends Actor{
  val random = new Random
  val childs = scala.collection.mutable.ListBuffer[ActorRef]()

  override def receive: Receive = {
    case CreateChild => childs ++= List(context.actorOf(Props[DoubleActor]))
    case Send => println(s"Sending messages to child")
      childs.zipWithIndex map {
        case (child, value) => child ! DoubleValue(random.nextInt(10))
      }
    case Response(x) => println(s"Parent: Response from child ${sender.path.name} is $x")
  }
}

object SendMessageToChild extends App{
  val actorSystem = ActorSystem("Hello-Akka")
  val parent = actorSystem.actorOf(Props[ParentActor], "parent")

  parent ! CreateChild
  parent ! CreateChild
  parent ! CreateChild
  parent ! Send
}
/*
  얻은 값을 두 배로 만드듣 DoubleActor 작식 액터를 만들었다.
  또한 CreateChild 메세지를 수신할 때 자식 액터를 만들어 리스트로 유지하는 부모 액터를 만들었다.
  부모 액터가 Send 메세지를 수신하면 난수를 자식에게 송신하고 자식은 부모에게 응답을 되돌려준다.
 */