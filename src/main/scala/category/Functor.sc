import cats._
import cats.instances.all._

//def map[A,B](fa: F[A], f: F[A] => F[B]): F[B]
/*
(fa : F[A]) — a data-type that take only one data-type
e.g List, Future , Options i.e List[String], List[Int], Option[Int] === F[A]

(f: A => B ) — a function that transform a type A to a type B
e.g function that takes a string and return an Int.

F[B] — the final return type of the Functor's map function
e.g if our "fa" variable is a List[String]
and our "f" function is String => Int , then our map function return type will be a List[Int]
*/

// Example 1
val len: String => Int = _.length
Functor[List].map(List("scala", "java"))(len)

// Example 2 - Standard scala there won't be map on Either
val r: Either[String, Int] = Right(100)
r.map(x => x + 2)

// Example 3 - nice fproduct

import cats.syntax.functor._

val fList = List("scala", "java").fproduct(len)
fList.toMap

// Example 4 - an alias to Map
List("scala", "java").fmap(len)

// Example 5 - unzip F(A,B) to (F[A], F[B])
List(("scala", 4)).unzip

// Example 6 - compose F[G[_]]
val listOption = List(Some(1), None, Some(2))
listOption.map(_.map(_ + 1))
listOption.map(_.map(_.toString))
listOption.map(println)
listOption.map(_.map(_.toString + "!!!").map(println))

Functor[List].compose[Option].map(listOption)(_ + 1)

// Example 7 - Error why check kind!
// Functor[Int].map(_)

// More to follow here -
// https://typelevel.org/cats/api/cats/Functor.html
// https://typelevel.org/cats/typeclasses/functor.html
// https://typelevel.org/cats/resources_for_learners.html

Seq(1, 2, 3).map(_.toDouble)
