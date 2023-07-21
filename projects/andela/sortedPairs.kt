import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val inputFile = args[0]
    println("You have passed $inputFile as input")

    val myMap = emptyMap<String, Int>().toMutableMap()

    val fileDescriptor = File(inputFile)

    val myList = fileDescriptor.readText().replace(", ", "").replace(".", "").replace(";", "").split(" ").sorted()

    println(myList)

    myList.forEach {
        if(myMap.containsKey(it)) {
            myMap[it] = myMap[it]!! + 1
        } else myMap[it] = 1
    }

    myMap.forEach{
        println(it)
    }
}
