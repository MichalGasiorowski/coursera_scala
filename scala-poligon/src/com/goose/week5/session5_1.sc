package com.goose.week5

// xs.length
// xs.last    --> Last element of the list except if xs is Empty
// xs.init    --> List consisting of all elements of xs except last one
// xs take n  --> List consisting of first n elements of xs ot xs itself if xs.length < n
// xs drop n  --> The rest of the collection after taking n elements
// xs(n)      --> Element of xs at index n.

// xs ++ ys   --> List consisting of all elements of xs followed by all ys
// xs.reverse --> reversed order
// xs updated (n, x) --> List containing same elements of xs except at index n where x
// xs indexOf x --> Index of first element in xs equal to x, or -1 if x does not appear in xs
// xs contains x --> same as xs indexOf x >= 0

// xs ::: ys


object session5_1 {
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  def removeAt[T](n: Int, xs: List[Int]): List[Int] =
  	(xs take n) ::: (xs drop n + 1 )          //> removeAt: [T](n: Int, xs: List[Int])List[Int]
  	//if(n<0 || xs.isEmpty) xs
  	//else if(n==0) xs.tail
  	//else xs.head :: removeAt(n-1, xs.tail)
  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => xs
  	case (y :: ys) :: gs => flatten(flatten(y :: ys) ++ gs )
  	case y :: ys => y :: flatten(ys)
  }                                               //> flatten: (xs: List[Any])List[Any]
  
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)
             	
  	
  	List(1, 2, 4) ::: List(6, 7, 8)           //> res1: List[Int] = List(1, 2, 4, 6, 7, 8)
  	
  	
}