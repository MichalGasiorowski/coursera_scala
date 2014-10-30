package com.goose.week5

// List(x1, ... , xn) reduceLeft op = (...(x1 op x2) op ... ) op xn
// instead of ((x, y) => x * y ) can write:
// (_ * _)

// foldLeft is like reduceLeft but takes accumulator z
// which is returned when foldLeft is called on Empty List

// foldRight & reduceRight
// applications of operator unfold on trees that lean to the right

// for operators : associative and commutative -> SAME

object session5_5 {
	val data = List(1, -4, 9, 4)              //> data  : List[Int] = List(1, -4, 9, 4)
	
	def mySum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _ )
                                                  //> mySum: (xs: List[Int])Int
 	def mySum2(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> mySum2: (xs: List[Int])Int
 	def myProduct2(xs: List[Int]) = (xs foldLeft 1) (_ * _)
                                                  //> myProduct2: (xs: List[Int])Int
	
	
	
	mySum2(data)                              //> res0: Int = 10
	myProduct2(data)                          //> res1: Int = -144
	
	
//	def concat[T](xs: List[T], ys: List[T]): List[T] =
//    (xs foldLeft ys) (_ :: _)

	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( (x, y ) =>  f(x) :: y )
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
    
	mapFun[Int, Boolean](data, _>3 )          //> res2: List[Boolean] = List(false, false, true, true)


	def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (_, y ) =>  y + 1 )         //> lengthFun: [T](xs: List[T])Int
	
	lengthFun(data)                           //> res3: Int = 4
	
}