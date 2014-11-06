package com.goose.week7

object session7_3 {
  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
 }                                                //> expr: => Int
 expr                                             //> xzyzres0: Int = 12
}