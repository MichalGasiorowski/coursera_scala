import scala.annotation.tailrec

object session1 {
  1 + 2

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs((guess * guess - x) / x) < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }


  sqrt(2)
  sqrt(0.001)
  sqrt(0.1e-20)
  sqrt(1.0e20)
  sqrt(1.0e50)

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)

  gcd(21, 14)

  def factorial(n: Int): Int = {
    def factorial_accu(n: Int, accu: Int): Int =
      if (n == 1) accu else factorial_accu(n - 1, accu * n)

    factorial_accu(n, 1)
  }

  factorial(10)
}