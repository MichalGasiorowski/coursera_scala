package com.goose.week4


trait MyList[+T] {
	def isEmpty: Boolean
	def head: T
	def tail: MyList[T]
	
	//def prepend(elem: T): List[T] = new Cons(elem, this) // doesn't compile
	
	def prepend [U >: T] (elem: U): MyList[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: MyList[T]) extends MyList[T] {
  def isEmpty = false
}

/*
class Nil[T] extends MyList[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
*/

object MyNil extends MyList[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("MyNil.head")
  def tail: Nothing = throw new NoSuchElementException("MyNil.tail")
}

object MyList {
  // List(1, 2)
  def apply[T](x1: T, x2: T): MyList[T] = new Cons(x1, new Cons(x2, MyNil))
  def apply[T](x1: T): MyList[T] = new Cons(x1, MyNil) 
  def apply[T](): MyList[T] = MyNil 
  
}

object test {
  val x: MyList[String] = MyNil
  //def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}
