object Main {
    def main(args: Array[String]): Unit = {

        def faOfb(x:Double) = KWF.compose(fa, fb)(x)
        def faOfbOfc(x:Double) = KWF.compose(faOfb, fc)(x)
        def faOfbOfcOfd(x:Double) = KWF.compose(faOfbOfc, fd)(x)
        
        println(10)                 // 10
        println(fa(10))             // fa(10) = 10 + 2 = 12
        println(faOfb(10))          // fb(fa(10)) = (10 + 2) * 2 = 24
        println(faOfbOfc(10))       // fc(fb(fa(10))) = ((10 + 2) * 2) - 2 = 22
        println(faOfbOfcOfd(10))    // fd(fc(fb(fa(10)))) = (((10 + 2) * 2) - 2) / 2 = 11
    }

    def fa(in: Double): KWF = KWF(in + 2)
    def fb(in: Double): KWF = KWF(in * 2)
    def fc(in: Double): KWF = KWF(in - 2)
    def fd(in: Double): KWF = KWF(in / 2)
}

class KWF(val value: Double) {
    var failed: Int = 0;
    def get: Double = value
    override def toString = value + "\tfailed: " + failed
}
object KWF{
    def apply(value: Double) = new KWF(value)
    def compose(f1: (Double) => KWF, f2: (Double) => KWF) : (Double) => KWF = {
        def f(i: Double) = f2(f1(i).get)
        f
    } 
}
