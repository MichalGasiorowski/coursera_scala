package com.goose.week5
import math.Ordering;

// scala.math.Ordering[T] provides ways to compare elements of type T

// implicit
// --> marked implicit
// --> has a type compatible with T
// --> is visible at the point of the function call, or is defined in a
// 		 companion object associated with T


object session5_3 {
	
	/*
	// parametrized version
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, _) => ys
          case (_, Nil) => xs
          case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }
  
  */
  
  // version with ordering
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, _) => ys
          case (_, Nil) => xs
          case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]
  
	msort(List(9, -9, 8, 1))                  //> res0: List[Int] = List(-9, 1, 8, 9)
  

}