package com.goose.week3

import com.goose.week3.Rational

object session3_2 {
  new Rational(1, 2)                              //> res0: com.goose.week3.Rational = 1/2
  
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  //error("msg")
  
  val x = null                                    //> x  : Null = null
  val y: String = x                               //> y  : String = null
  
  // val z: Int = null % cannot be done!
  
  if(true) 1 else false                           //> res1: AnyVal = 1
}