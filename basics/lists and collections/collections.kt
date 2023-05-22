fun main() {
//Collections
    val immutablelist = listOf("arun", "ramu")
    println(immutablelist[0])

    val mutablelist = mutableListOf("goa", "Khatmandu")
    println(mutablelist[0])
    mutablelist.add("Ranchi")
    println(mutablelist)

    val immutableset = setOf("earth", "moon", "mercury", "mercury") //duplicates are ignored
    println(immutableset)

    val mutableset = mutableSetOf("pen", "pencil")
    mutableset.add("slate pencil")
    println(mutableset)

    val immutablemap = mapOf("apple" to "Fruit", "Rose" to "Flower")
    println(immutablemap)
}