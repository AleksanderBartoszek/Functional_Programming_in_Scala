import akka.actor.{Actor, ActorRef, Props}

//noinspection AccessorLikeMethodIsUnit
class UserActor extends Actor {

  val polish: ActorRef = context.actorOf(Props[TranslatorActor])
  val spanish: ActorRef = context.actorOf(Props[TranslatorActor])
  val romanian: ActorRef = context.actorOf(Props[TranslatorActor])
  val italian: ActorRef = context.actorOf(Props[TranslatorActor])
  val german: ActorRef = context.actorOf(Props[TranslatorActor])

  polish ! SetPrefix("pl")
  spanish ! SetPrefix("esp")
  romanian ! SetPrefix("ro")
  italian ! SetPrefix("it")
  german ! SetPrefix("de")

  override def receive: Receive = {
    case a: Task => toEnglish(a.language, a.s)
    case a: English => toAll(a.w)
    case a: Answer => printAnswer(a)
  }

  def toEnglish(actor: ActorRef, s: String): Unit = actor ! s
  // sends original string to according translator

  def toAll(w: Word): Unit = {
    println("Original: " + w.native)
    polish ! Question(w.eng)
    spanish ! Question(w.eng)
    romanian ! Question(w.eng)
    italian ! Question(w.eng)
    german ! Question(w.eng)
  }
  // sends english string to every translator

  def printAnswer(a: Answer): Unit = {
    println("\t" + a.prefix + ": " + a.answer)
  }
}
