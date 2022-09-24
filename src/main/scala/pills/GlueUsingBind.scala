package pills

object GlueUsingBind extends App {

  //  def f(a: Int): (Int, String) = ???
  //  def g(a: Int): (Int, String) = ???
  //  def h(a: Int): (Int, String) = ???

  //  val fResult = f(100)
  //  val gResult = bind(g, fResult)
  //  val hResult = bind(h, hResult)


  //  (a:Int): (Int, String) OR (a: Int) => (Int, String)
  //   Result is Tuple2[Int, String]
  def bind(fun: (Int) => (Int, String), tup: (Int, String)): (Int, String) = {
    val givenInt = tup._1
    val givenString = tup._2

    // apply given funtion to given int
    val (intResult, stringResult) = fun(givenInt)

    // append stringResult to the given string
    val newString = givenString + stringResult

    // return the new int and string
    (intResult, newString)

    //OR val (intResult, stringResult) = fun(tup._1) (intResult, tup._2 + stringResult)
  }
}
