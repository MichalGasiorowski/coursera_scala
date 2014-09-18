object testWorksheet {
  val coins  = List(500,5,50,100,20,200,10, 50)   //> coins  : List[Int] = List(500, 5, 50, 100, 20, 200, 10, 50)
  coins.distinct.sorted(Ordering[Int].reverse)    //> res0: List[Int] = List(500, 200, 100, 50, 20, 10, 5)
}