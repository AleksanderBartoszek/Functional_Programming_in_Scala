object Main {
    def main(args: Array[String]): Unit = {
        val userInput = if(args.length > 0) args(0).toInt else 50
        printListOfNumbers(checkIfSquare(userInput))

        val x = Array.ofDim[Int](4,5)
        for ( i <- 0 until 4; j <- 0 until 5) x(i)(j) = i+j
        print2DArray(x)

        val y = Array.ofDim[Int](4,5)
        for ( i <- 0 until 4; j <- 0 until 5) y(i)(j) = i+j + ((i-1) * (j-1))
        print2DArray(y)

        print2DArray(merge2DArrays(x,y))
    }

    def checkIfSquare(limit: Int) : Array[Int] = {
        val checkedInts = for{x <- 1 to limit if Math.sqrt(x)%1 != 0} yield x
        return checkedInts.toArray
    }

    def printListOfNumbers(toPrint: Array[Int]) : Unit = {
        for(x <- 0 until toPrint.length) print(toPrint(x) + " ")
    }

    def print2DArray(toPrint: Array[Array[Int]]) : Unit = {
        print("\n")
        for (i <- 0 until toPrint.length){
            print("| ")
            for (j <- 0 until toPrint(i).length){
                print(toPrint(i)(j) + " ")
            }
            print("|\n")
        }
    }

    def merge2DArrays(arr1: Array[Array[Int]], arr2: Array[Array[Int]]) : Array[Array[Int]] ={
        val out = Array.ofDim[Int](arr1.length,arr1(0).length)
        for ( i <- 0 until arr1.length; j <- 0 until arr2(i).length){
            out(i)(j) = if(arr1(i)(j) > arr2(i)(j)) arr1(i)(j) else arr2(i)(j)
        }
        return out
    }
}
