object Main {
    def main(args: Array[String]): Unit = {
        val bk = new Bookkeeping()
        bk -= Expense(20, "lunch")
        bk -= Expense(200, "jacket")
        bk -= Expense(35, "hotel")
        bk += Income(1000, "subsistence", "10 October")
        bk -= Expense(130, "parking")
        bk -= Expense(320, "plane ticket")
        bk -= Expense(88, "food")
        bk -= Expense(100, "vet")
        bk += Income(1000, "subsistence", "10 November")
        bk -= Expense(100, "vet")
        bk -= Expense(15, "lunch")
        bk -= Expense(10, "coffee")
        bk += Income(1200, "subsistence", "10 December")

        //Tests
        println("------------------------------------")
        println("\tCurrent Balance = " + bk.getBalance())
        println("------------------------------------")
        println("\tIncomes:")
        bk.printIncomes()
        println("------------------------------------")
        println("\tExpenses:")
        bk.printExpenses()
        println("------------------------------------")
    }
}

class Bookkeeping {
    private var balance = 0
    private var incomes = List[Income]()
    private var expenses = List[Expense]()

    def +=(register: Income) = {
        incomes = incomes :+ register
        balance += register.amount
    }

    def -=(register: Expense) = {
        expenses = expenses :+ register
        balance -= register.amount
    }

    def getBalance() : Int = balance
    def printIncomes() = for(e <- incomes) println(e.ToString())
    def printExpenses() = for(e <- expenses) println(e.ToString())
}

class Expense(val amount: Int, val description: String){
    def ToString() : String = {
        "-" + amount + "---\"" + description + "\""
    }
}
object Expense {
    def apply(x: Int, y: String) = new Expense(x,y)
}

class Income(val amount: Int, val description: String, val date: String){
    def ToString() : String = {
        "+" + amount + "---\"" + description + "\"---" + date
    }
}
object Income {
    def apply(x: Int, y: String, z: String) = new Income(x,y,z)
}
