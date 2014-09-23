package com.goose.poligon

object session2_5 {
  val x = new Rational(1, 3)                      //> x  : com.goose.poligon.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : com.goose.poligon.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : com.goose.poligon.Rational = 3/2
  
  x.add(y)                                        //> res0: com.goose.poligon.Rational = 22/21
  x.neg                                           //> res1: com.goose.poligon.Rational = -1/3
  y.subtract(x)                                   //> res2: com.goose.poligon.Rational = 8/21
  
  
  x.subtract(y).subtract(z)                       //> res3: com.goose.poligon.Rational = -79/42
}

class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y
	
	def add(that: Rational) =
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom)
	
	def neg = new Rational(-numer, denom)
	def subtract(that: Rational) = add(that.neg)
	
	override def toString = numer + "/" + denom
}