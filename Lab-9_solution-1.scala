object Main {
    def main(args: Array[String]): Unit = {
        val l = List(1, "hello", 2.56, 0x45, "key")

        val s = stream(l)
        println(s) // result Int(1) String(hello) Double(2.56) Int(69) String(key)
    }

    def stream(x: List[Any]) : String = {
        x.map(convertToPrintable).mkString
    }

    def convertToPrintable(x: Any) : String = {
        x match {
            case i:Int => "Int(" + i + ") "
            case i:String => "String(" + i + ") "
            case i:Double => "Double(" + i + ") "
        }
    }
}
