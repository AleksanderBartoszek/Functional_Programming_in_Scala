object Main {
    def main(args: Array[String]): Unit = {
        val data = List( 
            Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
            Map("company" -> "ABB", "origin" -> "Sweden"),
            Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
            Map("company" -> "F4", "origin" -> "Poland"),
            List("Cos", "innego"),
            Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
            Map("company" -> "AGH", "origin" -> "Poland"),
            Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
        )

        print(getCompanies(data))
    }

    // calling pattern matching for every record provided
    // argument is List[Any] to be able to process incorrect records
    def getCompanies(data: List[Any]): List[Any] = {
        // getOrElse + filter is extremely messy but it sidesteps the problem of retrieveing values from List[Some(Company)]
        val output = for(e <- data) yield analyseRecord(e).getOrElse(None)
        output.toList.filter(_ != None)
    }

    // first step, filtering out non-Map containers, as only Maps can satisfy our requirements
    def analyseRecord(record: Any): Option[Company] = {
        // this type matching generates a warning
        record match {
            case map: Map[String, String] => analyseMap(map)
            case _ => None
        }
    }

    // second step, filtering out records without key "company", as every company must have this key
    def analyseMap(record: Map[String, String]): Option[Company] = {
        record.contains("company") match {
            case true => Some(new Company(
                record.get("company").get, 
                record.get("origin").get))
            case false => None 
        }
    }

    def print(output: List[Any]) = for(e <- output) println(e)
}

case class Company(companyName: String, origin: String)
