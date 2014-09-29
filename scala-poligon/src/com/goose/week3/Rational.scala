package com.goose.week3

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