package challenges

//object Palindrome extends App {
object Palindrome {
  def isPalindrome(word: String): Boolean = {
    val lower = word.toLowerCase()
    lower.reverse == lower
  }

  // println(isPalindrome("radar"))
  // println(isPalindrome("kayak"))
}


