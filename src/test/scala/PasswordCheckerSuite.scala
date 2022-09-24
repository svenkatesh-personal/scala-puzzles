package challenges

import munit.FunSuite

class PasswordCheckerSuite extends FunSuite {
  test("Valid passwords") {
    assert(PasswordChecker.isValidPassword("(Srinivas)"))
    assert(PasswordChecker.isValidPassword("afTeRyou!"))
    assert(PasswordChecker.isValidPassword("aopu_!!aA"))
  }

  test("Invalid passwords") {
    assert(!PasswordChecker.isValidPassword("a7680bN"))
    assert(!PasswordChecker.isValidPassword("asEqsssa"))
    assert(!PasswordChecker.isValidPassword("whatcrUX"))
  }
}
