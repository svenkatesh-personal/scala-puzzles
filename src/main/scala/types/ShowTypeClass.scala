package types
/*import cats.Show
import cats.instances.int._*/

// for all
import cats._
import cats.implicits._

object ShowTypeClass extends App {

  private val showInt: String = Show.apply[Int].show(20)
  println(showInt)
}
