package BoxInABox

/**
 * Created by Joseph on 22/01/2016.
 */
case class BuySellPair(buyPrice:Double, sellPrice:Double){
  def profit = sellPrice - buyPrice;
}