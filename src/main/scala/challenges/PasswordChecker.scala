package challenges

object PasswordChecker {

  def hasPunctuation(str: String): Boolean = {
    str.exists(char =>
      char == '.' ||
        char == ',' ||
        char == ':' ||
        char == ';' ||
        char == '?' ||
        char == '!' ||
        char == '"' ||
        char == '_' ||
        char == '(' ||
        char == ')')
  }

  def isValidPassword(password: String): Boolean = {
    password.size >= 8 &&
      password.exists(_.isUpper) &&
      password.exists(_.isLower) &&
      (password.exists(_.isDigit) || hasPunctuation(password))
  }
}
