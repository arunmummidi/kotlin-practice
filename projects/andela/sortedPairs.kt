import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    val inputFile = args[0]
    val fileDescriptor = File(inputFile)

    val myMap = emptyMap<String, Int>().toMutableMap()
    val wordList = fileDescriptor.readText().replace(", ", "").replace(".", "").replace(";", "").split(" ").sorted()

    wordList.forEach {
        if(myMap.containsKey(it)) {
            myMap[it] = myMap[it]!! + 1
        } else myMap[it] = 1
    }

    val sortedMap = myMap.entries.sortedByDescending { it.value }.associate { it.toPair() }

    sortedMap.forEach{
        println(it)
    }
}
