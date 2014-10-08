package com.goose.week4

object session4_6 {
  def show(e: Expr): String = e match {
  	case Number(x) => x.toString
  	case Sum(l, r) => show(l) + " + " + show(r)
  	// same for Prod & Var
  }                                               //> show: (e: com.goose.week4.Expr)String
  
  show(Sum(Number(1), Number(44)))                //> res0: String = 1 + 44
}