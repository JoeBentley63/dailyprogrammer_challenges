package BoxInABox

import scala.annotation.tailrec

/**
 * Created by Joseph on 22/01/2016.
 */
class TradingSolverSmarter(listOfTradeValues: List[Double]) {
  @tailrec
  final def solve(remainingValues:List[Double] = listOfTradeValues, bestSoFar:BuySellPair=BuySellPair(0,0)): BuySellPair = {
    if(remainingValues.length == 2) bestSoFar
    else {
      val bestForThisValue = BuySellPair(remainingValues.head, remainingValues.tail.tail.sortWith(_ > _).head)
      solve(remainingValues.tail, if (bestSoFar.profit >= bestForThisValue.profit) bestSoFar else bestForThisValue)
    }
  }
}