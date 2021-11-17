object Counter {
    def main(args: Array[String]): Unit = {
        println(countChar(args.toList))
    }

    def countChar(phrase: List[String]) : Int = {

        //counts in each word
        @scala.annotation.tailrec
        def countCharRec(counter: Int, arg: String): Int = {
            if(arg.isEmpty) return counter
            countCharRec(counter+1, arg.drop(1))
        }

        //counts whole list calling countCharRec for each word
        @scala.annotation.tailrec
        def countWordsRec(counter: Int, arg: List[String]): Int = {
            if(arg.isEmpty) return counter
            countWordsRec(counter + countCharRec(0, arg.head), arg.drop(1))
        }

        countWordsRec(0, phrase)
    }
}
