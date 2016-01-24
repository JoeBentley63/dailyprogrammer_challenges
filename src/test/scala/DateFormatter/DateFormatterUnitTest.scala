package DateFormatter

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by Joseph on 23/01/2016.
 */
class DateFormatterUnitTest extends FlatSpec with Matchers {

  "formatDates" should "format a bunch of inputs into the format YYYY-MM-DD" in {
    val dateFormatter = new DateFormatter();
    val result = dateFormatter.format(List(
    "2/13/15",
    "1-31-10",
    "5 10 2015",
    "2012 3 17",
    "2001-01-01",
    "2008/01/07"
    ))

    result shouldBe List(
      "2015-02-13",
      "2010-01-31",
      "2015-05-10",
      "2012-03-17",
      "2001-01-01",
      "2008-01-07"
    )
  }
}
