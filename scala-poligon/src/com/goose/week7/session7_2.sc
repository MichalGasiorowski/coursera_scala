package com.goose.week7

// Streams
// Stream(1, 2, 3)

// x :: xs always produces list, never a stream
// x #:: xs produces stream
// #:: can be used in expressions also in patterns

object session7_2 {
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)

  Stream(1, 2, 3)                                 //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  (1 to 1000).toStream                            //> res1: scala.collection.immutable.Stream[Int] = Stream(1, ?)

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    //print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]
  
  def isPrime(n: Int): Boolean = (2 until n).forall(x => n % x != 0)
                                                  //> isPrime: (n: Int)Boolean
  //((1000 to 10000).toStream filter isPrime)(1)
  
  //streamRange(1, 10).take(3).toList

}