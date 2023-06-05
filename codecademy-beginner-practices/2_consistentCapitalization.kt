/*
https://www.codecademy.com/resources/blog/kotlin-code-challenges-for-beginners/
2. Consistent capitalization

An important part of data preparation is to ensure that data strings are uniformly formatted and capitalized. For a given input string, create a function that accepts a string input as well as an argument string that’s either “upper” or “lower.”

If “upper,” then the function should convert everything in the string to upper case, while the “lower” argument should return the string with every character in lowercase.

To give yourself an added challenge, add the arguments “snake” and “camel” that convert a string of words separated by spaces into snake case or camel case.

thisissnake_case

ThisIsCamelCase*/

fun main() {
    transformCase("ARUN mummidi iS a DEMi goddu", "camel")
}

fun transformCase(inputString: String, action: String) {
    when(action) {
        "upper" -> println(inputString.uppercase())
        "lower" -> println(inputString.lowercase())
        "snake" -> {
            val words = inputString.split(' ').map { it.lowercase() }.toList()
            for(index in 0 until words.size) {
                if (index == words.size - 1) {
                    println(words[index])
                    return
                }
                print(words[index] + '_')
            }
        }
        "camel" -> {
            val words = inputString.split(' ').map { it.lowercase() }.toList()
            var characters = ""
            var outputString = ""
            var outputWordString = ""

            for(wordIndex in 0 until words.size){
                characters = words[wordIndex]
                outputString += characters[0].uppercase()
                for(index in 1 until characters.length){
                    outputString += characters[index]
                }
                outputWordString += outputString
                outputString = ""
            }

            println(outputWordString)
        }
    }
}
