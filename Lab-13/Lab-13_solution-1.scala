import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.{Failure, Random, Success}

object FutureMain extends App{
  val x = Random.alphanumeric
  val rstr = (x take 1000).toVector
  val found = psearch(rstr, 'x')

  found onComplete {
    case Success(f) => println("found " + f )
    case Failure(ex) => println(".")
  }

  def psearch(data: Vector[Char], ans: Char): Future[List[Char]] = {
    val divided = data.grouped(data.size/100).toList
    val answer = for(e <- divided) yield Future { subSearch(e, ans) }
    Future.sequence(answer)
  }
  
  def subSearch(data: Vector[Char], ans: Char): Char = {
    if (data.contains(ans))
      ans
    else
      '.'
  }
}
