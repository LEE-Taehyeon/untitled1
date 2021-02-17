package Chap01.P52

import akka.actor.{ActorRef, ActorSystem}
import akka.dispatch.{Envelope, MailboxType, MessageQueue, ProducesMessageQueue}
import sun.misc.ObjectInputFilter.Config

import java.util.concurrent.ConcurrentLinkedQueue

class MyMessageQueue extends MessageQueue{
  private final val queue = new ConcurrentLinkedQueue[Envelope]()
  override def enqueue(receiver: ActorRef, handle: Envelope): Unit = {
    if(handle.sender.path.name=="MyActor"){
      handle.sender ! "Hey dude, How are you?, I know your name, processing your request"
      queue.offer(handle)
    }else handle.sender ! "I don't talk to strangers, I can't process your request"
  }

  override def dequeue(): Envelope = queue.poll()

  override def numberOfMessages: Int = queue.size()

  override def hasMessages: Boolean = !queue.isEmpty

  override def cleanUp(owner: ActorRef, deadLetters: MessageQueue): Unit ={
    while(hasMessages) deadLetters.enqueue(owner, dequeue())
  }
}

class MyUnboundedMailBox extends MailboxType with ProducesMessageQueue[MyMessageQueue] {
  def this(setting:ActorSystem.Settings, config: Config) = this()
  final override def create(owner: Option[ActorRef], system: Option[ActorSystem]): MessageQueue = new MyMessageQueue()
}
