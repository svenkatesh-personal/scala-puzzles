List("scala", "23").map {
  _.length
}

case class Person(name: String, age: Int)

val person1 = Person("Srinivas", 33)
//person1.toJSON

trait ToJSON[A] {
  def toJSON(): String
}

implicit class PersonToJSON[Person](p: Person) extends ToJSON[Person] {
  override def toJSON(): String = s"$p.name"
}

person1.toJSON
