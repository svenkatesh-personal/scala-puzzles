import cats._
import cats.implicits._

2.some
Some(2)

none[Int]

"2".asRight[String]
Right("2")

"err".asLeft[Int]
Left("err")

"err".asLeft[Int].leftMap(new Exception(_))
"err".asLeft[Int].leftFlatMap(err => Left(new Exception(err)))
"err".asLeft[Int].bimap(err => new Exception(err), v => v.toLong)

"2".asRight[String].ensure _