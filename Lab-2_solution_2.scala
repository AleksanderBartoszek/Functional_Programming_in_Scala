object Main {
    def main(args: Array[String]): Unit = {

        val sum1 = sumfrac(1E-3) // 1.998046875
        val sum2 = sumfrac(1E-9) // 1.9999999981373549
        val sum3 = sumfrac(1E-16) // 2.0

        println(sum1)
        println(sum2)
        println(sum3)
    }

    def sumfrac(precision: Double) : Double = {
        @scala.annotation.tailrec
        def recSumFrac(currentValue: Double, n: Int) : Double = {
            if(1/Math.pow(2, n) < precision)
                return currentValue
            recSumFrac(currentValue + 1/Math.pow(2, n), n+1)
        }
        recSumFrac(0, 0)
    }
}
