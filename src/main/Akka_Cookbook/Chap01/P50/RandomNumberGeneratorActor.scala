package Chap01.P50

import Chap01.P50.Messages.{Done, GiveMeRandomNumber}
import akka.actor.{Actor, ActorRef}

import scala.util.Random.nextInt

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

