package com.goose.week5

// xs filterNot p 	<=> filter(x => !p(x))
// xs partition p		<=> (xs filter p, xs filterNot p)
// xs takeWhile p		<=> longest prefix of xs consisting of elements that satisfy p
// xs dropWhile p		<=> remainder of xs after any leading elem. that satisfy p
// xs span p				<=> (xs takeWhile p, xs dropWhile p)





object session5_4 {
	/*
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => Nil
  	case y :: ys => y*y :: squareList(ys)
  }
  */
  def squareList(xs: List[Int]): List[Int] =
  	xs map(x => x*x)                          //> squareList: (xs: List[Int])List[Int]
  
  squareList(List(1,2,3,4))                       //> res0: List[Int] = List(1, 4, 9, 16)
  
  def posElems(xs: List[Int]): List[Int] =
  	xs filter (x => x > 0)                    //> posElems: (xs: List[Int])List[Int]
  
  
  val nums = List(2, -4, 5, 8, 14, -7)            //> nums  : List[Int] = List(2, -4, 5, 8, 14, -7)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  nums filter 	(x => x > 0)                      //> res1: List[Int] = List(2, 5, 8, 14)
  nums filterNot(x => x > 0)                      //> res2: List[Int] = List(-4, -7)
  nums partition(x => x > 0)                      //> res3: (List[Int], List[Int]) = (List(2, 5, 8, 14),List(-4, -7))
  
  nums takeWhile(x => x > 0)                      //> res4: List[Int] = List(2)
	nums dropWhile(x => x > 0)                //> res5: List[Int] = List(-4, 5, 8, 14, -7)
	nums span(x => x > 0)                     //> res6: (List[Int], List[Int]) = (List(2),List(-4, 5, 8, 14, -7))
	
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 => val (v1, v2 ) = xs span(y => y == x)
										 v1 :: pack(v2)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
	pack(data)                                //> res7: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
	
	def encode[T](xs: List[T]): List[(T, Int)] =
		pack(xs) map(el => (el.head, el.length) )
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
	encode(data)                              //> res8: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
		
	
	
	
	
	
	
}