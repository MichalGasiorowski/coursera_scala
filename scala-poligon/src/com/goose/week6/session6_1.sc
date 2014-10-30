package com.goose.week6
// xs exists p
// xs forall p
// xs zip ys
// xs.unzip
// xs flatMap f applies collection-valued function f
//						to all elements of xs and concatenates results
// xs.sum
// xs.product
// xs.max
// xs.min

object session6_1 {
	val xs = Array(1, 2, 3, 66)               //> xs  : Array[Int] = Array(1, 2, 3, 66)
	xs map(x => x * 2)                        //> res0: Array[Int] = Array(2, 4, 6, 132)
	
	val s = "Hello World"                     //> s  : String = Hello World
	s filter (c => c.isUpper)                 //> res1: String = HW
	
	val r: Range = 1 until 5                  //> r  : Range = Range(1, 2, 3, 4)
	val s2: Range = 1 to 5                    //> s2  : Range = Range(1, 2, 3, 4, 5)
	
	1 to 10 by 3                              //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
	
	s exists(c => c.isUpper)                  //> res3: Boolean = true
	s forall(c => c.isUpper)                  //> res4: Boolean = false
	
	val pairs = List(1,2,3) zip s             //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
	pairs.unzip                               //> res5: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
	
	s flatMap (c => List('.',c))              //> res6: String = .H.e.l.l.o. .W.o.r.l.d
	val M = 4                                 //> M  : Int = 4
	val N = 5                                 //> N  : Int = 5
	
	(1 to M) flatMap(x => (1 to N) map (y => (x, y)))
                                                  //> res7: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (1,4), (1,5), (2,1), (2,2), (2,3), (2,4), (2,5), (3,1), (3,2), (3,
                                                  //| 3), (3,4), (3,5), (4,1), (4,2), (4,3), (4,4), (4,5))
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  	(xs zip ys).map(xy => xy._1 * xy._2).sum  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
   
  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  	(xs zip ys).map{case (x, y) => x * y}.sum //> scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double
	
	def isPrime(n: Int): Boolean =
		(2 until n).forall(x => n % x != 0)
                                                  //> isPrime: (n: Int)Boolean
		
	isPrime(3)                                //> res8: Boolean = true
	isPrime(6)                                //> res9: Boolean = false
		
		
}