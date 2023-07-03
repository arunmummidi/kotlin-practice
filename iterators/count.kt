fun names(namesList: List<String>): List<String> {
    var count = 0
    val mySet = mutableSetOf<String>()

    var outerIterator = ""
    namesList.forEach{
        count = 0
        outerIterator = it
        namesList.forEach{
            if (it == outerIterator) {
                count++
            }
        }

        mySet.add("The name $it is repeated $count times")
    }
    return  mySet.toList()
}


fun main() {
    val nameList = listOf("Vasya", "Olga", "Vasya", "Dima", "Masha", "Vasa", "Olga")
    val count = names(nameList)
    println(count)
}
