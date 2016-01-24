package SecretSantaSorter

/**
 * Created by Joseph on 22/01/2016.
 */
class SecretSanta {

  def pick(names:List[String]): List[SantaPair] = {
    val processedNames = processNames(names)
    findPair(processedNames.head, processedNames.tail, List.empty)
  }

  private def findPair(name: Name, possiblePeople: List[Name], pairs:List[SantaPair]): List[SantaPair] ={
    val newPair:SantaPair = SantaPair(name, possiblePeople.filter(person => person.matchingIdentifier != name.matchingIdentifier).head)
    val remainingPeople = possiblePeople.filterNot(name => name == newPair.secondPerson)
    if(remainingPeople.length > 1) findPair(remainingPeople.sortBy(name => !name.inFamily).head, remainingPeople.tail, pairs :+ newPair)
    else pairs :+ newPair
  }

  private[SecretSantaSorter] def processNames(names:List[String]) = {
      names.foldLeft(List.empty: List[Name])((allNames, nameString )=> {
        val splitNames = nameString.split(" ")
        val listOfNamesInTheString = splitNames.map(name => Name(name, nameString, splitNames.length != 1))
        allNames++listOfNamesInTheString
      })
  }
}
