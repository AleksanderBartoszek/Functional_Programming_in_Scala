object Main {
    def main(args: Array[String]): Unit = {
        println(pi)
        println(pi(pi))
        println(pi(pi(pi)))

        printarg(arg = "Hello")
        printarg()

        println(repN(5, (x: Int) => 2*x, 1))
    }

    def pi = 3.1415

    def pi(fun: => Double) : Double = pi * fun

    def printarg(arg: => String = "-") = println(arg)

    def repN(count: Int, fun: Int => Int, start: Int) : Int = {
        if(count == 0) return start
        repN(count-1, fun, fun(start))
    }
}
