import challenges.Palindrome
import munit.FunSuite

class PalindromeSuite extends FunSuite {
  test("Words which are Palindromes") {
    assert(Palindrome.isPalindrome("radar"))
    assert(Palindrome.isPalindrome("kayak"))
  }

  test("Words which are not Palindromes") {
    assert(!Palindrome.isPalindrome("Raj"))
    assert(!Palindrome.isPalindrome("Class"))
  }

  test("Ignore case") {
    assert(Palindrome.isPalindrome("level"))
    assert(Palindrome.isPalindrome("LEVEL"))
  }
}
