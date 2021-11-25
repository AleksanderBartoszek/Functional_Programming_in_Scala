object Main {
    def main(args: Array[String]): Unit = {
        val myPizza = new ThinDough with TomatoSauce with Mozarella with Ham
        println( myPizza.name + myPizza.price )
        val yourPizza = new ThinDough with TomatoSauce with Mozarella with Mushrooms
        println( yourPizza.name + yourPizza.price )
    }
    /* expected result
        Ham  Mozarella  Tomato Sauce  on thin dough 14.0
        Mushrooms  Mozarella  Tomato Sauce  on thin dough 14. */
}

abstract class Pizza {
    def name : String
    def price : Double
}

class ThinDough extends Pizza {
    def name : String = "on thin dough "
    def price : Double = 7 // custom
}

trait PizzaIngredient extends Pizza {
    override abstract def name : String
    override abstract def price : Double
}

trait TomatoSauce extends PizzaIngredient { 
    override abstract def name : String = "Tomato Sauce " + super.name
    override abstract def price : Double = 1 + super.price //custom
}

trait Mozarella extends PizzaIngredient {
    override abstract def name : String = "Mozarella " + super.name
    override abstract def price : Double = 4 + super.price // custom
}

trait Ham extends PizzaIngredient {
    override abstract def name : String = "Ham " + super.name
    override abstract def price : Double = 2 + super.price // custom
}

trait Mushrooms extends PizzaIngredient {
    override abstract def name : String = "Mushrooms " + super.name
    override abstract def price : Double = 2 + super.price // custom
}
