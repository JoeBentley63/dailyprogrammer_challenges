package DateFormatter

/**
 * Created by Joseph on 23/01/2016.
 */
class DateFormatter {

  def format(dates: List[String]):List[String] = dates.map(date => {
     val splitStrings = date.split(" ")++date.split("-")++date.split("/") filterNot(someDate => date==someDate)
     if(splitStrings(0).length == 4) formatDate (splitStrings(0), splitStrings(1), splitStrings(2))
     else formatDate (splitStrings(2), splitStrings(0), splitStrings(1))
  })

  private def formatDate(year:String, month:String, day:String):String =
  {
    val dayString = formatDateComponent(day)
    val monthString = formatDateComponent(month)
    val yearString = formatDateComponent(year, 4, "20")
    s"$yearString-$monthString-$dayString"
  }
  private def formatDateComponent(value:String, expectedLenght:Int = 2, prefixIfLengthIsTooSmall:String = "0"):String = if (value.length == expectedLenght) value else prefixIfLengthIsTooSmall + value
}

