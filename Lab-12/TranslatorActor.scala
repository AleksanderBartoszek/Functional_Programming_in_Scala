import akka.actor.{Actor, ActorRef, Props}

class TranslatorActor extends Actor {
  val superStar: ActorRef = context.actorOf(Props[UserActor], name = "SuperStar")
  var prefix = ""

  override def receive: Receive = {
    case s: String => translate(s)
    case s: SetPrefix => prefix = s.prefix
    case q: Question => reverseTranslate(q.question)
  }

  def translate(s: String): Unit = {
    val fileData = DictFile.read(prefix)
    val word = fileData.find(p => p.native == s).getOrElse(Word("Not Found", "Not Found"))
    superStar ! English(word)
  }

  def reverseTranslate(s: String): Unit = {
    val fileData = DictFile.read(prefix)
    val word = fileData.find(p => p.eng == s).getOrElse(Word("Not Found", "Not Found"))
    superStar ! Answer(word.native, prefix)
  }
}
