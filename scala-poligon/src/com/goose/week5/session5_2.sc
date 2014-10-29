package com.goose.week5

// splitAt  --> returns two sublists (as pair):
// 						-> the elements up the given index
//						-> the elements from that index

// Pair and Tuples
// (x, y) ex:
// val pair = ("answer", 42) 		 --> type: (String, Int)
// Pairs can be used as patterns
// val (label, value) = pair
// tuple type (T1, ..., Tn) is an abbreviation of parameterized type:
// scala.Tuplen[T1, ..., Tn]

// tuple expression (e1, ... , en) is equivalent to the function application
// scala.Tuplen(e1, ... , en)

// tuple pattern (p1, ... , pn) is equivalent to the constructor pattern:
// scala.Tuplen(p1, ... , pn)

// Tuple class:
// modeled after class:
// case class Tuple2[T1, T2](_1: +T1, _2: +T2) {
//		override def toString = "(" + _1 + "," + _2 + ")"
// }

// accessors : _1, _2, ...


object session5_2 {

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length/2
		if (n == 0) xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] =
			(xs, ys) match {
				case (Nil, _) 						=> ys
				case (_, Nil) 			=> xs
				case (x :: xs1, y :: ys1) => if(x < y) x :: merge(xs1, ys)
																		else y :: merge(xs, ys1)
			}
			/*
				xs match {
					case Nil => ys
					case x :: xs1 =>
						ys match {
							case Nil => xs
							case y :: ys1 => if(x < y) x :: merge(xs1, ys)
							else y :: merge(xs, ys1)
						}
				}
				*/
			val (fst, snd) = xs splitAt n
			merge(msort(fst), msort(snd))
		}
	}                                         //> msort: (xs: List[Int])List[Int]
	
	msort(List(9, -9, 8, 1))                  //> res0: List[Int] = List(-9, 1, 8, 9)
	
	
}