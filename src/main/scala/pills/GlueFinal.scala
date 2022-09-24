package pills

object GlueFinal extends App {

  // def f(a: Int): (Int, String) = ???
  // def g(a: Int): (Int, String) = ???
  // def h(a: Int): (Int, String) = ???

  def f(a: Int): (Int, String) = {
    val result = a * 2
    (result, s"\nf result: $result.")
  }

  def g(a: Int): (Int, String) = {
    val result = a * 3
    (result, s"\ng result: $result.")
  }

  def h(a: Int): (Int, String) = {
    val result = a * 4
    (result, s"\ng result: $result.")
  }

  def bind(fun: Int => (Int, String), tup: (Int, String)): (Int, String) = {
    val (intResult, stringResult) = fun(tup._1)
    (intResult, tup._2 + stringResult)
  }

  // get the output of f
  val fResult = f(100)
  val gResult = bind(g, fResult)
  val hResult = bind(h, gResult)

  println(s"result: ${hResult._1}, debug: ${hResult._2}")

  // why can't we write like this
  /*val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult
  println("xxx " + hResult)*/

}
