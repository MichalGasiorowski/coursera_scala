package com.goose.week3

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}



// def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
// singleton[T](1)
// singleton(1) -> also possible type parameter are deducible for scala compiler

// type erasure