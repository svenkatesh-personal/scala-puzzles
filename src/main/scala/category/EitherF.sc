import scala.concurrent.Future //imports the Futures
import scala.concurrent.ExecutionContext.Implicits.global //import the implicit ExecutionContext

//returns table of the input if its not zero
def getTable(num: Int): Future[List[Int]] = Future {
  if (num == 0) {
    List.empty[Int]
  } else {
    (1 to 10).toList.map(_ * num)
  }
}

//flatMap call on future
val flatMapMagic: Future[List[Int]] = getTable(0) flatMap {
  case Nil => Future.failed(throw new RuntimeException("arg is zero"))
  case table => Future.successful(table)
}

// https://typelevel.org/cats/datatypes/eithert.html
import scala.util.Try
import cats.data.EitherT
import cats.implicits._

def parseDouble(s: String): Either[String, Double] =
  Try(s.toDouble).map(Right(_)).getOrElse(Left(s"$s is not a number"))
// parseDouble: (s: String)Either[String,Double]

def divide(a: Double, b: Double): Either[String, Double] =
  Either.cond(b != 0, a / b, "Cannot divide by zero")
// divide: (a: Double, b: Double)Either[String,Double]

def parseDoubleAsync(s: String): Future[Either[String, Double]] =
  Future.successful(parseDouble(s))
def divideAsync(a: Double, b: Double): Future[Either[String, Double]] =
  Future.successful(divide(a, b))

def divisionProgramAsync(inputA: String, inputB: String): EitherT[Future, String, Double] =
  for {
    a <- EitherT(parseDoubleAsync(inputA))
    b <- EitherT(parseDoubleAsync(inputB))
    result <- EitherT(divideAsync(a, b))
  } yield result

divisionProgramAsync("4", "2").value

def x(s: String): Either[String, Double] = Left("some string")
x("xyz")

def y(s: String): Either[String, Double] = Right(9.0).withLeft[String]
y("xyz")

def z(s: String): Either[String, Double] = Right(9)
z("xyz")

val errorT: EitherT[Future, String, Int] = EitherT.leftT("foo")
// errorT: cats.data.EitherT[scala.concurrent.Future,String,Int] = EitherT(Future(Success(Left(foo))))

val error: Future[Either[String, Int]] = errorT.value
// error: scala.concurrent.Future[Either[String,Int]] = Future(Success(Left(foo)))
