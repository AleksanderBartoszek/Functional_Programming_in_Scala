object Main {
    def main(args: Array[String]): Unit = {
        // tests
        val a = Angle(233.14)
        val b = Angle(-45.26)
        val c = Angle(1.53)
        val d = Angle.HalfPi
        val e = Angle.Pi
        val f = Angle.Zero
        val g = a-b
        val h = Angle.DR(a,b)(c,d)
        val i = a*1.5

        println(a.angle)    
        println(b.angle)    
        println(c.angle)    
        println(d.angle)    
        println(e.angle)   
        println(f.angle) 
        println(g.angle)   
        println(h.angle)   
        println(i.angle)      
    }
}

class Angle(val angle: Double){
    def +(x: Angle): Angle = new Angle(angle + x.angle)
    def -(x: Angle): Angle = new Angle(angle - x.angle)
    def *(x: Angle): Angle = new Angle(angle * x.angle)
    def /(x: Angle): Angle = new Angle(angle / x.angle)

    def *(x: Double): Angle = new Angle(angle * x)
    def /(x: Double): Angle = new Angle(angle / x)
}

object Angle{
    def apply(x: Double) = new Angle(wrapper(x))

    def Pi = new Angle(math.Pi)
    def HalfPi = new Angle(math.Pi/2)
    def Zero = new Angle(0)

    def sqrt(x: Angle): Angle = new Angle(Math.sqrt(x.angle))
    def DR(a1: Angle, a2: Angle)(a3: Angle, a4: Angle) : Angle = {
        sqrt((a1-a2)*(a1-a2) + (a3-a4)*(a3-a4))
    }

    @scala.annotation.tailrec
    def wrapper(value: Double): Double = {
        if(value > math.Pi) wrapper(value - 2*math.Pi)
        else if(value < -math.Pi) wrapper(value + 2*math.Pi)
        else value
    }
}
