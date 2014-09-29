package com.goose.poligon

object session2_7 {
  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be nonzero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)
    def numer = x / g
    def denom = y / g


    def < (that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom

    def max(that: Rational) = if (this < that) that else this

    def + (that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom)

    def unary_- = new Rational(-numer, denom)
    def - (that: Rational) = this + -that

    override def toString = {
      numer + "/" + denom
    }

  }
  
  val x = new Rational(1, 3)                      //> x  : com.goose.poligon.session2_7.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : com.goose.poligon.session2_7.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : com.goose.poligon.session2_7.Rational = 3/2

  x + y // infix notation                         //> res0: com.goose.poligon.session2_7.Rational = 22/21
  -x                                              //> res1: com.goose.poligon.session2_7.Rational = 1/-3
  y - x                                           //> res2: com.goose.poligon.session2_7.Rational = 8/21
  
  x - y - z                                       //> res3: com.goose.poligon.session2_7.Rational = -79/42
  y + y                                           //> res4: com.goose.poligon.session2_7.Rational = 10/7
  
  x < y                                           //> res5: Boolean = true
  
  (-6) % 2                                        //> res6: Int(0) = 0
}