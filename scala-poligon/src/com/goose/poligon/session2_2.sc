package com.goose.poligon

object session2_2 {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	if(a > b) 1
  	else f(a) * product(f)(a+1,b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  /*
    def fun(a: Int, b: Int): Int =
      if (a > b) 1
      else f(a) * fun(a + 1, b)
    fun(a, b)
  }
  */
  def fact(n: Int): Int =
  	product(x => x)(1,n)                      //> fact: (n: Int)Int
  
  def general(f: Int => Int)(combine: (Int, Int) => Int, identity: Int)(a: Int, b: Int): Int = {
  	if(a > b) identity
  	else combine(f(a), general(f)(combine, identity)(a+1, b))
  }                                               //> general: (f: Int => Int)(combine: (Int, Int) => Int, identity: Int)(a: Int, 
                                                  //| b: Int)Int
                                                  
  def product2(f: Int => Int)(a: Int, b: Int): Int = general(f)( (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  general(x => x)( (x, y) => x + y, 0)(1, 2)      //> res0: Int = 3
  
  
  product2(x => x)(1, 3)                          //> res1: Int = 6
  fact(3)                                         //> res2: Int = 6
}