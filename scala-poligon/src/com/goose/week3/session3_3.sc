package com.goose.week3

import com.goose.week3._

object session3_3 {
  def nth[T](n: Int, xs: List[T]): T =
  	if(xs.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) xs head
    else nth(n - 1, xs tail)                      //> nth: [T](n: Int, xs: com.goose.week3.List[T])T

	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : com.goose.week3.Cons[Int] = com.goose.week3.Cons@13b0d75f
	
	nth(4, list)                              //> java.lang.IndexOutOfBoundsException
                                                  //| 	at com.goose.week3.session3_3$$anonfun$main$1.nth$1(com.goose.week3.sess
                                                  //| ion3_3.scala:7)
                                                  //| 	at com.goose.week3.session3_3$$anonfun$main$1.apply$mcV$sp(com.goose.wee
                                                  //| k3.session3_3.scala:13)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at com.goose.week3.session3_3$.main(com.goose.week3.session3_3.scala:5)
                                                  //| 
                                                  //| 	at com.goose.week3.session3_3.main(com.goose.week3.session3_3.scala)
}