object Main {
    def main(args: Array[String]): Unit = {
        val c: Plants = new Carrot
        val r = new Rabbit
        val w = new Wolf
        val a: Animal = r
        val f: Food = r
        
        // this two should compile and run w/o problems
        r.eat(c)
        w.eat(r)
        // whereas these should not compile
        //r.eat(r)
        //w.eat(c)
        // Expected result: 
        // Rabbit crunches the  Carrot
        // Wolf tears apart the Rabbit
    }
}

abstract class Food {
    val name : String
    override def toString() = name
}
abstract class Plants extends Food
abstract class Animal extends Food with EatingHabit {
    def eat(meal: acceptedFood) = println(name + " crunches the " + meal)
}

class Carrot extends Plants {
    val name = "Carrot"
}
class Rabbit extends Animal with EatingPlants{
    val name = "Rabbit"
}
class Wolf extends Animal with EatingMeat{
    val name = "Wolf"
}

trait EatingHabit {
    type acceptedFood
}
trait EatingPlants {
    type acceptedFood <: Plants
}
trait EatingMeat {
    type acceptedFood <: Animal 
}
