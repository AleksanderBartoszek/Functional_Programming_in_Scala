object Main {
    def main(args: Array[String]): Unit = {
        val result = compose(msq, mcube)(2.1)
        println(result.toString())
    }

    def msq(x:Double): DocumentedValue = DocumentedValue(x*x, "--squaring--") 
    def mcube(x:Double): DocumentedValue = DocumentedValue(x*x*x, "--cubing--")

    def compose(f1: (Double) => DocumentedValue, f2: (Double) => DocumentedValue) = { 
        def f(x: Double): DocumentedValue = {
            val compValue: Double = f2(f1(x).value).value
            val catMsg: String = f1(x).msg + "\n\t" + f2(x).msg
            DocumentedValue(compValue, catMsg)
        }
        f _
    }
}

class DocumentedValue(val value: Double,  val msg: String){
    override def toString() = "Operations:\n\t" + msg + "\nresult = " + value
}
object DocumentedValue{
    def apply(value: Double, msg: String) = new DocumentedValue(value, msg)
}
