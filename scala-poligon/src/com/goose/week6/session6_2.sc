package com.goose.week6

object session6_2 {
	def isPrime(n: Int): Boolean = (2 until n).forall(x => n % x != 0)
                                                  //> isPrime: (n: Int)Boolean

	val n = 7                                 //> n  : Int = 7
	
	 val xss = (1 until n) map (i =>
		(1 until i) map (j => (i, j)))    //> xss  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.Inde
                                                  //| xedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), 
                                                  //| Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1
                                                  //| ), (6,2), (6,3), (6,4), (6,5)))
		
  (xss foldRight Seq[Any]())(_ ++ _)              //> res0: Seq[Any] = Vector((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,
                                                  //| 2), (5,3), (5,4), (6,1), (6,2), (6,3), (6,4), (6,5))
	
	xss.flatten                               //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
  (1 until n) flatMap (i =>
  	(1 until i) map (j => (i, j))) filter(pair =>
  		isPrime(pair._1 + pair._2))       //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
	// For-Expressions
	
	// for ( p <- persons if p.age > 20) yield p.name		<=>
	// persons filter (p => p.age > 20) map (p => p.name)
	// For-expression similar to loops
	// but without side-effect
	// For-expression produces result ( yield )
	
	// for ( s ) yield e
	// where s is a sequence of generators and filters
	// e is an expression whose value is returned by an iteration
	// -> A generator is of form p <- e ( p pattern, e expression
	// -> A filter is of form if f where f is a boolean expression
	// -> THe sequence must start with a generator
	// -> If there are several generators in the sequence, the last
	// 	  generators vary faster that the first
	// Instead of ( s ) braces { s } can be used -> then sequence can be written on multiple lines
	
	for {
		i <- 1 until n
		j <- 1 until i
		if isPrime(i + j)
	} yield (i, j)                            //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))
	
	def scalarProduct(xs: List[Double], ys: List[Double]): Double =
		(for ((x, y) <- xs zip ys ) yield x*y).sum
                                                  //> scalarProduct: (xs: List[Double], ys: List[Double])Double
	
	scalarProduct(List(1, 3, 8), List(2, 5, 10))
                                                  //> res4: Double = 97.0
	
	
	
}