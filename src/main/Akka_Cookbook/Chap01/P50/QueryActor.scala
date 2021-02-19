package Chap01.P50

import akka.actor.{Actor, ActorSystem, Props}
import Messages.{Done, GiveMeRandomNumber}
import akka.actor.{Actor, ActorRef}
import scala.util.Random.nextInt


/*
  아카 기반 앱에는 많은 액터가 있으며, 액터끼리 통신하는 방법은 여러 가지이다.
  두 액터가 통신하는 방법
 */
object Messages{
  case class Done(randomNum:Int)
  case object GiveMeRandomNumber
  case class Start(actorRef:ActorRef)
}

class RandomNumberGeneratorActor extends Actor {
  override def receive: Receive = {
    case GiveMeRandomNumber => println("received a message to generate a random integer")
      val randomNumber = nextInt
      sender ! Done(randomNumber)
  }
}

class QueryActor extends Actor {
  import Messages._
  override def receive: Receive = {
    case Start(actorRef) => println(s"send me the next random number")
      actorRef ! GiveMeRandomNumber
    case Done(randomNum) => println(s"received a random number $randomNum")
  }
}

object Communication extends App{
  import Messages._
  val actorSystem = ActorSystem("randomNumGeneratorActorSystem")
  val actor = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "randomNumGeneratorActor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "queryActor")

  queryActor ! Start(actor)
}
