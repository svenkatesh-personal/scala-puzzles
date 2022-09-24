import cats.instances.list._
import cats.instances.either._
import cats.syntax.traverse._

// List[Either[A, B]] to Either[A, List[B]]
val traverseEg: List[Either[String, Int]] = List(Right(1), Right(2), Right(3))

val result1 = traverseEg.sequence