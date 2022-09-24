package pills

object GlueFG2 extends App {

  // def f(a: Int): (Int, String) = ???
  // def g(a: Int): (Int, String) = ???

  def f(a: Int): (Int, String) = {
    val result = a * 2
    (result, s"\nf result: $result.")
  }

  def g(a: Int): (Int, String) = {
    val result = a * 3
    (result, s"\ng result: $result.")
  }

  // get the output of f
  val (fInt, fString) = f(100)

  // plug the Int from f as the input to g
  val (gInt, gString) = g(fInt)

  val debug = fString + " " + gString
  println(s"result: $gInt, debug: $debug")
}
