package com.goose.week4



object session4_6 {
  def show(e: Expr): String = e match {
  	case Number(x) => x.toString
  	case Sum(l, r) => show(l) + " + " + show(r)
  	// same for Prod & Var
  }                                               //> show: (e: com.goose.week4.Expr)String
  
  show(Sum(Number(1), Number(44)))                //> res0: String = 1 + 44
  
  val myList = List(('a', 1), ('b', 2) , ('c', 3))//> myList  : List[(Char, Int)] = List((a,1), (b,2), (c,3))
  
  myList.map { case (c, i) => if (c == 'a') (c, i+1) else (c, i) }
                                                  //> res1: List[(Char, Int)] = List((a,2), (b,2), (c,3))
  
  
  def times(chars: List[Char]): List[(Char, Int)] = {
    def timesRec(chars: List[Char], accu: List[(Char, Int)]): List[(Char, Int)] =
       chars match {
       		case List() => accu
       		case y :: ys => if(!accu.exists( pair => pair._1 == y)  )
       							timesRec(ys,
       						(y, 1) :: accu) else
       		  				timesRec(ys, accu map { case(c, v) => if(c == y) (c, v+1) else (c, v) } )
    	}
      timesRec(chars, List() )
   
  }                                               //> times: (chars: List[Char])List[(Char, Int)]
  val K = List(1, 2, 3)                           //> K  : List[Int] = List(1, 2, 3)
  val L = times(List('a', 'b', 'a'))              //> L  : List[(Char, Int)] = List((b,1), (a,2))
  
  L.sortBy(item => item._2)                       //> res2: List[(Char, Int)] = List((b,1), (a,2))
  
  K.+:(4)                                         //> res3: List[Int] = List(4, 1, 2, 3)
  K :+ 4                                          //> res4: List[Int] = List(1, 2, 3, 4)
  
  
  
}