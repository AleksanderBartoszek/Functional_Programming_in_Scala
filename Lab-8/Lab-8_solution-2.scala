object Main {
    def main(args: Array[String]): Unit = {
        val people = List( 
            ("John", "Doe", 23, "male"), 
            ("Joan", "Doe", 23, "female"),
            ("Steve", "Jenkins", 22, "male"),
            ("Eva", "Robinson", 25, "female"),
            ("John", "Who", 22, "male"), 
            ("Janet", "Reed", 21, "female"),
            ("Rob", "Jenkins", 22, "male"), 
            ("Ella", "Dawson", 27, "female") 
        )

        val namesList = people.collect(_._1)
        val namesSet = namesList.toSet
        val agesSet = people.collect(_._3).toSet
        val splitByAge23 = people.groupBy(_._3 < 23)
        val groupByAge = people.groupBy(_._3)
        val sortByAge = people.sortBy(_._3)
        val existsJoeOrRob = people.exists(_._1 == "Joe") || people.exists(_._1 == "Rob")
        val equalMalesAndFemales = people.map(x => x._4).groupBy(x => x).map(x => x._2.length).fold(0)((x, y) => y - x) == 0

        println(namesList + "\n")
        println(namesSet + "\n")
        println(agesSet + "\n")
        println(splitByAge23 + "\n")
        println(groupByAge + "\n")
        println(sortByAge + "\n")
        println(existsJoeOrRob + "\n")
        println(equalMalesAndFemales + "\n")
    }
}
