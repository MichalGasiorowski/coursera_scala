package forcomp

import forcomp.Anagrams._

object testSheet {
  val w = "abracadabra"                           //> w  : String = abracadabra

  val s = List("I", "AM", "GOD")                  //> s  : List[String] = List(I, AM, GOD)

  //  val dictionary = List("abba", "baba", "cde", "xyz")

  wordAnagrams("plate")                           //> res0: List[forcomp.Anagrams.Word] = List(leapt, petal, plate, pleat)

  //(w.groupBy(e => e).toList map (c => (c._1, c._2.length ))).sortBy(p => p._1)

  //((for ((c, cc) <- w.groupBy(e => e)) yield (c, cc.length)).toList).sortBy(p =>p._1)

  val smallD = dictionary take 10                 //> smallD  : List[forcomp.Anagrams.Word] = List(Aarhus, Aaron, Ababa, aback, ab
                                                  //| aft, abandon, abandoned, abandoning, abandonment, abandons)
  val occurrences = List(('a', 2), ('b', 2), ('c', 2))
                                                  //> occurrences  : List[(Char, Int)] = List((a,2), (b,2), (c,2))



  //val comb = combinations(occurrences)
  //comb.length
  
  occurrences.toMap withDefaultValue 0            //> res1: scala.collection.immutable.Map[Char,Int] = Map(a -> 2, b -> 2, c -> 2)
                                                  //| 
  val occurrences2 = List(('a', 2), ('b', 2))     //> occurrences2  : List[(Char, Int)] = List((a,2), (b,2))
  
  subtract(occurrences, occurrences2)             //> res2: forcomp.Anagrams.Occurrences = List((c,2))
  
  //dictionaryByOccurrences
  val sentence = List("Yes", "man")               //> sentence  : List[String] = List(Yes, man)
  
  sentenceOccurrences(sentence)                   //> res3: forcomp.Anagrams.Occurrences = List((a,1), (e,1), (m,1), (n,1), (s,1),
                                                  //|  (y,1))
  sentenceAnagrams(sentence)                      //> res4: List[forcomp.Anagrams.Sentence] = List(List(my, en, as), List(my, as, 
                                                  //| en), List(my, sane), List(my, Sean), List(yes, man), List(en, my, as), List(
                                                  //| en, as, my), List(men, say), List(as, my, en), List(as, en, my), List(say, m
                                                  //| en), List(man, yes), List(sane, my), List(Sean, my))
  
  
  
}