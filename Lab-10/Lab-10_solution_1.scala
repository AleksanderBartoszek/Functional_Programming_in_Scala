object Main extends App {
  val testData = List(-8, 5, 6, 1, 4, 4, 2, 5, -1, 9, 9)

  println(repeated(testData))
  println(notRepeated(testData))
  println(conRepeated(testData))

  def repeated(value: List[Any]): List[Any] = value.diff(value.distinct)

  def notRepeated(value: List[Any]): List[Any] = value.distinct.diff(repeated(value))

  def conRepeated(value: List[Any]): List[Any] = {
    value.sliding(2, 1).map(x => x.toSet).filter(x => x.size == 1).toList.flatten
  }

  println(
    condMerge(
      List(2, -9, 1, 8),
      Vector(3, -2, 45, 2),
      { case x: (Int, Int) if Math.max(x._1, x._2) > 0 => Math.max(x._1, x._2) case _ => 0 }))
  // should give: List(3, 45, 8) but gives: List(3, 0, 45, 8).
  // Couldn't find a way to cleanly process mapping to nothing when max < 0, so I added additional case to cover that

  def condMerge(x: Iterable[Int], y: Iterable[Int], z: ((Int, Int)) => Int): List[Int] = {
    x.zip(y).map(z).toList
  }

  case class Person(id: Int, age: Int, name: String)
  val team = List(Person(0, 25, "Jerry"), Person(1, 34, "Jane"), Person(2, 25, "Jim"), Person(3, 19, "Judith"))

  println(select_from(team, (x: Person) => x.id, 1, 3)) // gives: List(Person(1,34,Jane),Person(3, 19, Judith))
  println(select_from(team, (x: Person) => x.age, 25)) // gives: List(Person(0,25,Jerry), Person(2,25,Jim))

  def select_from(data: List[Person], f: Person => Int, add: Int*): List[Person] = {
    data.filter(x => add.contains(f(x)))
  }
}
