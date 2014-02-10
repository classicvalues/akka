package docs.faq

import akka.actor.Actor

//#exhaustiveness-check
object MyActor {
  // these are the messages we accept
  sealed abstract trait Message
  case class FooMessage(foo: String) extends Message
  case class BarMessage(bar: Int) extends Message

  // these are the replies we send
  sealed abstract trait Reply
  case class BazMessage(foo: String) extends Reply
}

class MyActor extends Actor {
  import MyActor._
  def receive = {
    case message: Message ⇒ message match {
      case BarMessage(bar) => sender ! BazMessage("Got " + bar)
    }
  }
}
//#exhaustiveness-check