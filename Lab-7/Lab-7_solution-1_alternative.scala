object Main {
    def main(args: Array[String]): Unit = {

        def faOfb(x:Double) = compose(fa, fb)(x)
        def faOfbOfc(x:Double) = compose(faOfb, fc)(x)
        def faOfbOfcOfd(x:Double) = compose(faOfbOfc, fd)(x)
        
        println(10)                 // 10
        println(fa(10))             // fa(10) = 10 + 2 = 12
        println(faOfb(10))          // fb(fa(10)) = (10 + 2) * 2 = 24
        println(faOfbOfc(10))       // fc(fb(fa(10))) = ((10 + 2) * 2) - 2 = 22
        println(faOfbOfcOfd(10))    // fd(fc(fb(fa(10)))) = (((10 + 2) * 2) - 2) / 2 = 11

        println(irresponsibleFunction(10))
    }

    def fa(in: Double): KWF = KWF(in + 2)
    def fb(in: Double): KWF = KWF(in * 2)
    def fc(in: Double): KWF = KWF(in - 2)
    def fd(in: Double): KWF = KWF(in / 2)

    def irresponsibleFunction(in: Double): KWF = KWF("Error")

    def compose(f1: (Double) => KWF, f2: (Double) => KWF) = {
        def f(x: Double) = {
            val compValue: Double = f2(f1(x).value).value
            KWF(compValue)
        }
        f _
    } 
}

class KWF(val value: Double, var failed: Int = 0) {
    override def toString = value + "\tfailed: " + failed
}
object KWF{
    def apply(value: Any) = {
        value match {
            case x: Double => {
                if(!x.isInfinity) new KWF(x)
                else {
                    val next = new KWF(Double.PositiveInfinity) 
                    next.failed += 1
                    next
                }
            }
            case _ => {
                val next = new KWF(Double.PositiveInfinity) 
                next.failed += 1
                next
            }
        }
    }
}
