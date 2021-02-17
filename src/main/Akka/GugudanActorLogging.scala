import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging
import scala.concurrent._
import scala.concurrent.duration._

//println이 아닌 logging을 사용하여 출력
class GugudanActorLogging(promise: Promise[Unit]) extends Actor{
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case x:Int=>
      println("<-"+x+"단 입니다.->")
      for(i<-1 to 9) println(x+" X "+i+" = "+x*i)
      if (x == 9) promise.success()

    case _ => println("숫자가 아닙니다.")
  }
}

object GugudanActorLoggingCreate extends App{
  val actorSystem = ActorSystem("gugudanActorSystemLogging")

  val promise = Promise[Unit]()
  val actor = actorSystem.actorOf(Props(classOf[GugudanActorLogging], promise), "gugudanActorLogging")

  for(i<-2 to 9) actor ! i


  Await.ready(promise.future, 10.seconds)//ActorSystem을 terminate(종료)를 시켜서 안찍혔던거임
  actorSystem.terminate()
  //pringln은 동기, logs는 비동기로 동작
}