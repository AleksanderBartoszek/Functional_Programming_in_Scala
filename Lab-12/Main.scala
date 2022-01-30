import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("Default")
  val superStar = system.actorOf(Props[UserActor])

  val polish = system.actorOf(Props[TranslatorActor])
  val spanish = system.actorOf(Props[TranslatorActor])
  val romanian = system.actorOf(Props[TranslatorActor])
  val italian = system.actorOf(Props[TranslatorActor])
  val german = system.actorOf(Props[TranslatorActor])

  // probably can be done cleaner without calling each one with it's prefix
  polish ! SetPrefix("pl")
  spanish ! SetPrefix("esp")
  romanian ! SetPrefix("ro")
  italian ! SetPrefix("it")
  german ! SetPrefix("de")

  //running translation
  superStar ! Task(spanish, "como")
}
