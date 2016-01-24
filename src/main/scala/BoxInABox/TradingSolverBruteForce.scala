package BoxInABox

import scala.annotation.tailrec

/**
 * Created by Joseph on 22/01/2016.
 */
class TradingSolverBruteForce(listOfTradeValues: List[Double]) {
  def solve = iter(listOfTradeValues, BuySellPair(0,0))

  @tailrec
  private def iter(resultSetToSearch:List[Double], bestSolutionYet:BuySellPair):BuySellPair = {
    if(resultSetToSearch.length < 3) bestSolutionYet
    else {
      val currentLargest = testCase(resultSetToSearch.head, resultSetToSearch.tail.tail, bestSolutionYet)
      iter(resultSetToSearch.tail, currentLargest)
    }
  }

  @tailrec
  private def testCase(value:Double, restOfTradeValues:List[Double], currentLargest:BuySellPair):BuySellPair = {
    if(restOfTradeValues.isEmpty) currentLargest
    else {
      val buySellPair: BuySellPair = BuySellPair(value, restOfTradeValues.head)
      if (buySellPair.profit >= currentLargest.profit){
        testCase(value, restOfTradeValues.tail, buySellPair)
      }
      else testCase(value, restOfTradeValues.tail, currentLargest)
    }
  }
}
