//package Chap02.P72
//
//import akka.actor.{Actor, ActorRef, OneForOneStrategy}
//
//import scala.concurrent.duration
//import scala.concurrent.duration.DurationInt
//
//class ActorLifeCycle {}
//
///*
//  액터의 생명주기 훅(life cycle hooks)에 대해 알아보자.
//  액터가 시작, 중단, 재시작, 시작 전에 생명주기 훅을 오버라이드하는 밥업을 배운다.
// */
//
//case object Error
//case class StopActor(actorRef:ActorRef)
//
//class LifeCycleActor extends Actor{
//  var sum = 1
//
//  override def preRestart(reason: Throwable, message: Option[Any]): Unit = println(s"sum in preRestart is $sum")
//  override def receive: Receive = {
//    case Error => throw new ArithmeticException()
//    case _ => println("default msg")
//  }
//
//  override def preStart(): Unit = println(s"sum in postStop is ${sum * 3}")
//
//  override def postRestart(reason: Throwable): Unit = {
//    sum = sum * 2
//    println(s"sum in postRestart is $sum")
//  }
//}
//
//class Supervisor extends App{
//  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute)
//}
