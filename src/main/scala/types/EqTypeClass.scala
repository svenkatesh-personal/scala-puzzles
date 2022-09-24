package types

import cats._
import cats.implicits._

object EqTypeClass extends App {

  //  val userOption = Option("srinivas")
  //  val optionToCompare = userOption.fold(false)(_ == "srinivas")
  //  println(optionToCompare)

  //  val userEither = Right("kumar")
  //  val eitherCompare = userEither.fold(_ => false, _ == "kumar")
  //  println(eitherCompare)
  //
  //  val filtered = List(Option(1), Option(2), Option(3), None).filter(_.fold(true)(_ != 2))
  //  println(filtered)

  val userOption = Option("srinivas")
  val optionToCompare = userOption === "srinivas".some
  println(optionToCompare)

  val userEither = Right("kumar")
  val eitherCompare = userEither === "kumar".asRight[String]
  println(eitherCompare)

  val filtered = List(Option(1), Option(2), Option(3), None).filter(_ =!= 2.some)
  println(filtered)
}
