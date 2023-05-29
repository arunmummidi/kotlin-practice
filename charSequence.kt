/*
Write a function that takes in a CharSequence and returns
a new CharSequence with every other character of the original one removed.
For example, if the input is "Hello, world!", the output should be "Hlo ol!"*/
fun main() {
    val test = removeEveryOtherChar("arun")
    println(test)
}

fun removeEveryOtherChar(input: CharSequence): CharSequence {
    var processedMutableList = mutableListOf<Char>()
    for (element in input.indices) {
        if (element % 2 == 0) {
            processedMutableList += input[element].toChar()
        }
    }
    return processedMutableList.joinToString("")
}
