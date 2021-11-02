object Main {
    def main(args: Array[String]): Unit = {
        val list = List("Hello", "There", "people")
        println(list)
        println(reverseList(list))
        println(filterList(list, _.contains('p')))
    }

    // def filterList(list: List[String], f: (String) => Boolean) = list.filter(f)
    def filterList(list: List[String], f: (String) => Boolean) = {
        var filtered = List[String]()
        @scala.annotation.tailrec
        def filterListRec(list: List[String], counter: Int) : List[String] = {
            if(counter <= 0) return filtered
            if(f(list.head)) filtered = filtered :+ list.head
            filterListRec(list.drop(1), counter-1)
        }
        filterListRec(list, list.length)
    }
    
    // def reverseList(list: List[String]) = list.reverse
    def reverseList(list: List[String]): List[String] = {
        @scala.annotation.tailrec
        def reverseListRec(reversed : List[String], todo: List[String]) : List[String] = {
            if(todo.isEmpty) return reversed
            reverseListRec(reversed :+ todo.last, todo.dropRight(1))
        }
        reverseListRec(List.empty, list)
    }
}
