package com.goose.week6

// maps
// orderBy
// groupBy - partitions collection into a map of collections
// according to a discriminator function f

object session6_6 {
  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V ->
                                                  //|  5, X -> 10)

  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  // maps are functions too!
  capitalOfCountry("US")                          //> res0: String = Washington
  capitalOfCountry get "Andorra"                  //> res1: Option[String] = None

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "missing data"
  }                                               //> showCapital: (country: String)String

  showCapital("US")                               //> res2: String = Washington
  showCapital("Andorra")                          //> res3: String = missing data

  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)

  fruit sortWith (_.length < _.length)            //> res4: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res5: List[String] = List(apple, orange, pear, pineapple)

  fruit groupBy (_.head)                          //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))

  class Poly(val terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue 0.0
    //def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def +(other: Poly) =
      new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }
    
    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }
	/*
	def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
      terms get exp match {
 				case Some(coeff1) => exp -> (coeff + coeff1)
 				case None => exp -> coeff
 			}
 			
    }
	*/

  //val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : com.goose.week6.session6_6.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : com.goose.week6.session6_6.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res7: com.goose.week6.session6_6.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
                                                  //| 
  val cap1 = capitalOfCountry withDefaultValue "<unknown>" // default value
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washingto
                                                  //| n, Switzerland -> Bern)

  p1.terms(7)                                     //> res8: Double = 0.0

}