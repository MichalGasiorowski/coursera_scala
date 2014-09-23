package com.goose.poligon

object session2_6 {

  class Rational(x: Int, y: Int) {
  	require(y != 0, "denominator must be nonzero")
  	
  	def this(x: Int) = this(x, 1)
  
  	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  	private val g = gcd(x, y)
    //def numer = x / g
    //def denom = y / g
    
    def numer = x
    def denom = y

		def less(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
		
		def max(that: Rational) = if(this.less(that)) that else this
		
    def add(that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom)

    def neg = new Rational(-numer, denom)
    def subtract(that: Rational) = add(that.neg)

    override def toString = {
    	val g = gcd(x, y)
    	numer / g + "/" + denom / g // excersise is lecture 2.6
    }
    
  }

  val x = new Rational(1, 3)                      //> x  : com.goose.poligon.session2_6.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : com.goose.poligon.session2_6.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : com.goose.poligon.session2_6.Rational = 3/2

  x add y // infix notation                       //> res0: com.goose.poligon.session2_6.Rational = 22/21
  x.neg                                           //> res1: com.goose.poligon.session2_6.Rational = 1/-3
  y.subtract(x)                                   //> res2: com.goose.poligon.session2_6.Rational = 8/21

  x.subtract(y).subtract(z)                       //> res3: com.goose.poligon.session2_6.Rational = -79/42
  y.add(y)                                        //> res4: com.goose.poligon.session2_6.Rational = 10/7
  
  x.less(y)                                       //> res5: Boolean = true
  
   
}