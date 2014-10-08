package com.goose.week4


object session4_7 {
  val fruit = List("apples", "oranges", "pears")  //> fruit  : List[String] = List(apples, oranges, pears)
  val diag3 = List(List(1,0,0), List(0,1,0), List(0,0,1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
                                                  
  val fruit2: List[String] = List("apples", "oranges", "pears")
                                                  //> fruit2  : List[String] = List(apples, oranges, pears)
  val nums: List[Int] = List(1, 2, 3, 4)          //> nums  : List[Int] = List(1, 2, 3, 4)
  val diag3p: List[List[Int]] = List(List(1,0,0), List(0,1,0), List(0,0,1))
                                                  //> diag3p  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1)
                                                  //| )
  val empty: List[Nothing] = List()               //> empty  : List[Nothing] = List()
 
 	// all lists are constructed from:
 	// empty list Nil and:
 	// construction operation :: ( cons )
 	// x :: xs
 	// operators ending ":" associate to the right
 	// A :: B :: C <=> A :: (B :: C)
 	// Operators ending in ":" are seen as method calls of the RIGHT-HAND operand
 	// 1 :: (2 :: (3 :: (4 :: Nil)))
 	// <=>
 	// Nil.::(4).::(3).::(2).::(1)

	val fruit3 = "apples" :: ("oranges" :: ("pears" :: Nil ))
                                                  //> fruit3  : List[String] = List(apples, oranges, pears)
  val nums3 = 1 :: (2 :: (3 :: (4 :: Nil)))       //> nums3  : List[Int] = List(1, 2, 3, 4)
  val empty3 = Nil                                //> empty3  : scala.collection.immutable.Nil.type = List()
	
	// head
	// tail
	// isEmpty
	
	// List Patterns
	// Nil 						 => The Nil constant
	// p :: ps  			 => A pattern that matches a list with a head matching p and tail matching ps
	// List(p1, .. pn) => Same as p1 :: p2 :: ... :: pn :: Nil
	
	def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() 		=> x :: Nil
		case y :: ys 		=> x <= y match {
												case true => x :: xs
												case false => y :: insert(x, ys)
											}
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]
	
}