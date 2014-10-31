package com.goose.week6

object session6_4 {
  case class Book(title: String, authors: List[String])

	// mini-database
  val books: Set[Book] = Set(  //  List[Book] = List(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming",
      authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))
                                                  //> books  : Set[com.goose.week6.session6_4.Book] = Set(Book(Programming in Scal
                                                  //| a,List(Odersky, Martin, Spoon, Lex, Venners, Bill)), Book(Structure and Inte
                                                  //| rpretation of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), 
                                                  //| Book(Effective Java,List(Bloch, Joshua)), Book(Introduction to Functional Pr
                                                  //| ogramming,List(Bird, Richard, Wadler, Phil)), Book(Java Puzzlers,List(Bloch,
                                                  //|  Joshua, Gafter, Neal)))
      
  	for(b <- books; a <-b.authors if a startsWith "Bloch,")
  	yield b.title                             //> res0: scala.collection.immutable.Set[String] = Set(Effective Java, Java Puzz
                                                  //| lers)
  	
  	for(b <- books if b.title.indexOf("Program") >= 0)
  	yield b.title                             //> res1: scala.collection.immutable.Set[String] = Set(Programming in Scala, Str
                                                  //| ucture and Interpretation of Computer Programs, Introduction to Functional P
                                                  //| rogramming)
   
   	for {
   		b1 <- books
   		b2 <- books
   		if b1.title < b2.title
   		a1 <- b1.authors
   		a2 <- b2.authors
   		if a1 == a2
   	} yield a1                                //> res2: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
   	// distinct
   	
   	
}