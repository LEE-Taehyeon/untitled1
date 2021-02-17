package Chap01

import Chap01.P50.RandomNumberGeneratorActor
import akka.actor.{Actor, ActorSystem, Props}

class QueryActor extends Actor {
  import Chap01.P50.Messages._
  override def receive: Receive = {
    case Start(actorRef) => println(s"send me the next random number")
      actorRef ! GiveMeRandomNumber
    case Done(randomNum) => println(s"received a random number $randomNum")
  }
}

object Communication extends App{
  import Chap01.P50.Messages._
  val actorSystem = ActorSystem("randomNumGeneratorActorSystem")
  val actor = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "randomNumGeneratorActor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "queryActor")

  queryActor ! Start(actor)
}