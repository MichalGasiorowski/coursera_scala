package com.goose.week6

// Scala compiler expresses for-expressions in terms
// of map, flatMap and a lazy variant of filter

// for(x <- e1) yield e2
// is translated to
// e1.map(x => e2)

// 1.
// for(x <- e1 if f; s) yield e2
// where f is a filter and s is a (potentially empty) sequence of
// generators and filters, is translated to

// 2.
// for(x <- e1.withFilter(x => f); s) yield e2
// withFilter -> variant of filter that does not produce an
// intermediate list, but instead filters the following map or
// flatMap function application.

// 3.
// for(x <- e1; y <- e2; s) yield e3
// e1.flatMap(x => for (y <- e2; s) yield e3)





object session6_5 {
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
                                                  //> books  : Set[com.goose.week6.session6_5.Book] = Set(Book(Programming in Sca
                                                  //| la,List(Odersky, Martin, Spoon, Lex, Venners, Bill)), Book(Structure and In
                                                  //| terpretation of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)
                                                  //| ), Book(Effective Java,List(Bloch, Joshua)), Book(Introduction to Functiona
                                                  //| l Programming,List(Bird, Richard, Wadler, Phil)), Book(Java Puzzlers,List(B
                                                  //| loch, Joshua, Gafter, Neal)))
  
  for(b <- books; a <- b.authors if a.startsWith("Bird"))
  	yield b.title                             //> res0: scala.collection.immutable.Set[String] = Set(Introduction to Function
                                                  //| al Programming)
                                                  
 	books.flatMap(b => for(a <- b.authors if a.startsWith("Bird") ) yield b.title )
                                                  //> res1: scala.collection.immutable.Set[String] = Set(Introduction to Function
                                                  //| al Programming)
 	
 	books.flatMap(b => for(a <- b.authors.withFilter(a => a.startsWith("Bird")) ) yield b.title )
                                                  //> res2: scala.collection.immutable.Set[String] = Set(Introduction to Function
                                                  //| al Programming)
 	
  //books.flatMap(b =>
  //	b.authors.withFilter(a => a.startsWith("Bird")) ) map (y => y.title) )
  	                                           
  
                                                  
 //books.flatMap(b => b.authors.withFilter(a => a.startsWith("Bird") ) yield b.title )
      
  
}