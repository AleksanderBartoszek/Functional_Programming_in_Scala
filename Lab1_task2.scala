object Main {
    def main(args: Array[String]): Unit = {
        println(sumAll(1,2,3,4,5))

        println(repN(5, (x: Int) => 2*x , 1 ))

        var memory_1 = 0
        def accumulator_1() = {(x:Int) => memory_1 += x; memory_1}
        var memory_2 = 0
        def accumulator_2() = {(x:Int) => memory_2 += x; memory_2}

        val ac1 = accumulator_1()
        val ac2 = accumulator_2()
        println(ac1(1)) // prints 1
        println(ac1(7)) // prints 8
        println(ac2(3)) // prints 3 
        println(ac1(7)) // prints 15
    }

    def sumAll(input: Int*): Int = {
        var output = 0;
        for(e <- input) output += e;
        return output
    }

    def repN(count: Int, fun: Int => Int, value: Int) : Int = {
        if(count == 0)  return value
        repN(count-1, fun, fun(value))
    }
}
