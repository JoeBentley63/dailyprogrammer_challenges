package SecretSantaSorter

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Joseph on 22/01/2016.
  */
class SecretSantaUnitTest extends FlatSpec with Matchers{

   "Secret Santa " should "return list of santa buddies" in {
     val secretSanta = new SecretSanta();
     val result:List[SantaPair] = secretSanta.pick(List(
     "james",
     "joe claire",
     "pat"
     ))

     result.length shouldBe 2
   }

  "Secret Santa " should "return list of santa buddies, with a large test data set" in {
    val secretSanta = new SecretSanta();
    val result:List[SantaPair] = secretSanta.pick(List(
      "Sean",
      "Winnie",
      "Brian Amy",
      "Samir",
      "Joe Bethany",
      "Bruno Anna Matthew Lucas",
      "Gabriel Martha Philip",
      "Andre",
      "Danielle",
      "Leo Cinthia",
      "Paula",
      "Mary Jane",
      "Anderson",
      "Priscilla",
      "Regis Julianna Arthur",
      "Mark Marina",
      "Alex Andrea"
    ))

    result.length shouldBe 15
  }

  "Secret Santa " should "return list of santa buddies, and families should not be matched together" in {
    val secretSanta = new SecretSanta();
    val result:List[SantaPair] = secretSanta.pick(List(
      "james",
      "joe claire",
      "pat"
    ))

    result contains(SantaPair(Name("joe", "joe claire", true),Name("claire", "joe claire", true))) shouldBe false
  }

  "sortInputs" should "sort a list of names, and extract members of the same family" in {
    val secretSanta = new SecretSanta();
    val result = secretSanta.processNames(List(
      "james",
      "joe claire",
      "pat"
    ))
    result shouldBe List(
      Name("james", "james"),
      Name("joe", "joe claire", true),
      Name("claire", "joe claire", true),
      Name("pat", "pat")
    )
  }
 }
