package recfun
import common._

import scala.collection.immutable.Stack;

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if(c == 0 || c == r) 1
    else pascal(c, r -1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isParenthesis(char: Char): Boolean =
      char == ')' || char == '('
    def isOpenPara(char: Char): Boolean =
      char == '('
    def isClosePara(char: Char): Boolean =
      char == ')'
        
    def balanceIter(chars: List[Char], count: Int): Boolean =
      if(chars.isEmpty) count == 0
      else if(!isParenthesis(chars.head)) balanceIter(chars.tail, count)
      else if(isOpenPara(chars.head)) balanceIter(chars.tail, count + 1)
      else if(count == 0) false
      else balanceIter(chars.tail, count - 1)
      
    balanceIter(chars, 0)
    }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countIter(moneyLeft: Int, sortedCoins: List[Int]): Int =
      if(moneyLeft == 0) 1
      else if(moneyLeft < 0 || sortedCoins.isEmpty) 0
      else countIter(moneyLeft - sortedCoins.head, sortedCoins) + 
      	countIter(moneyLeft, sortedCoins.tail)
      
      countIter(money, coins.distinct.sorted(Ordering[Int].reverse))
      
  }
    
    
    
    
    
}
