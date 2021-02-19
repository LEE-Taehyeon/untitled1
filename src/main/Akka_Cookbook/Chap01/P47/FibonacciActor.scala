//package Chap01.P47
//
//import akka.actor.{Props, ActorSystem, Actor}
//import akka.pattern.ask
//import akka.util.Timeout
//import scala.concurrent.Await
//import scala.concurrent.duration._
//
///*
//  액터가 무언가를 한 뒤 결과를 얻는 방법
// */
//class FibonacciActor extends Actor {
//  override def receive: Receive = {
//    case num: Int =>
//      val fibonacciNumber = fib(num)
//      sender ! fibonacciNumber
//  }
//
//  def fib(n: Int): Int = n match {
//    case 0 | 1 => n
//    case _ => fib(n - 1) + fib(n - 2)
//  }
//}
//
//// 피보나치 숫자를 계산하는 액터를 만들었으며, 피보나치를 걔산하도록 메세지를 액터에 보낸 송신자에게 결과를 송신했다.
//// 액터에게 ? 를 사용해 메세지를 보낼 때, 작업이 완료되면 결과를 얻게 될 것이라고 약속해주는 퓨처를 반환한다.
//object FibonacciActorApp extends App {
//  implicit val timeout = Timeout(10 seconds)
//  val actorSystem = ActorSystem("HelloAkka")
//
//  val actor = actorSystem.actorOf(Props[FibonacciActor])
//
//
//  // asking for result from actor
//  val future = (actor ? 10).mapTo[Int]
//  val fiboacciNumber = Await.result(future, 10 seconds)
//  println(fiboacciNumber)
//}
