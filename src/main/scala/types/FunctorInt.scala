package types

import cats._
import cats.implicits._

object FunctorInt extends App {

  // def doMath[F[_]](start: F[Int])(implicit functor: Functor[F]): F[Int] = start.map(_ + 12)
  def doMath[F[_] : Functor](start: F[Int]): F[Int] = start.map(_ + 12)

  val resultO = doMath(Option(27))
  val resultL = doMath(List(27, 90))

  println(resultL)
}
