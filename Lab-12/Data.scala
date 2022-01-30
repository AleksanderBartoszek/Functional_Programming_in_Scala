import akka.actor.ActorRef

case class Task(language: ActorRef, s: String)
// initial -> who and what string

case class Question(question: String)
// english string to form a Word for translator

case class English(w: Word)
// first type of answer -> Word(native, english)

case class Answer(answer: String, prefix: String)
// end answer to print, every translator sends it to master

case class SetPrefix(prefix: String)
// sets translator to correct file
