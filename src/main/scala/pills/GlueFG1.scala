package pills

object GlueFG1 extends App {

  // def f(a: Int): Int = ???
  // def g(a: Int): Int = ???

  def f(a: Int): Int = a * 2

  def g(a: Int): Int = a * 3

  val x = g(f(100))
  println(x)
}
