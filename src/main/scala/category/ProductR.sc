import cats.implicits._

Some("a")

"a".some  //widened to supertype


val success1 = "a".asRight[Int]
val success2 = "b".asRight[Int]

val failure = 400.asLeft[String]

success1 *> success2

success2 *> success1

success1 *> failure

failure *> success1

success2 *> failure *> success1


// parametric polymorphism
def head[A](xs: List[A]): A = xs(1)
head(1 :: 2 :: Nil)

case class Car(make: String)
head(Car("Honda") :: Car("Ertiga") :: Nil)

// subtype polymorphism


// adhoc polymorphism
trait CanPlus[A] {
  def plus(a1: A, a2: A): A
}

def plus[A: CanPlus](a1: A, a2: A): A = implicitly[CanPlus[A]].plus(a1, a2)

// scala programming projects book - refer variance and lang. spec
trait Animal
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal
val animal1: Animal = Cat("Max")
val animal2: Animal = Dog("Dolly")
implicitly[Dog <:< Animal]
