import scala.io.Source

case class Word(native: String, eng: String)

object DictFile {
  def read(cc: String): List[Word] = {
    val fileName = "/Users/aleksanderbartoszek/Desktop/AkkaTest/src/main/scala/" + cc + "1000.txt"
    val fileBuffer = Source.fromFile(fileName)
    val flatContent = fileBuffer.getLines().toList
    val words = flatContent.grouped(3).map(d => {
      Word(d(1), d(2))
    }).toList
    fileBuffer.close()
    words
  }
}
