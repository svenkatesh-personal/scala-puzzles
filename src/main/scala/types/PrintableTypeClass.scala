package types

trait Printable[A] {
  def print(value: A): String
}

object PrintableInstances {
  implicit def stringPrintable: Printable[String] = (input: String) => input

  implicit def intPrintable: Printable[Int] = (input: Int) => input.toString
}

// Interface Object
object PrintableObject {
  def toPrint[A](value: A)(implicit p: Printable[A]): String = p.print(value)
}

// Interface Syntax
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def print(implicit p: Printable[A]): String = p.print(value)
  }
}


object Main extends App {

  import PrintableInstances._
  import PrintableSyntax._

  //implicitly[Printable[String]]

  println(PrintableObject.toPrint("MyString1"))

  println("MyString2".print)

  println(100.print)
}
