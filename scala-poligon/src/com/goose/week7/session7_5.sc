package com.goose.week7

object session7_5 {
	val problem = new Pouring(Vector(4, 9, 19))
                                                  //> problem  : com.goose.week7.Pouring = com.goose.week7.Pouring@6df97b55
	
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with c
                                                  //| om.goose.week7.session7_5.problem.Move] = Vector(Empty(0), Empty(1), Empty(2
                                                  //| ), Fill(0), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Po
                                                  //| ur(2,0), Pour(2,1))
	//problem.pathSets.take(3).toList
  problem.solution(17)                            //> res1: Stream[com.goose.week7.session7_5.problem.Path] = Stream(Fill(0) Pour(
                                                  //| 0,2) Fill(1) Fill(0) Pour(0,2) Pour(1,2)-->Vector(0, 0, 17), ?)
}