/*
3. The longest word

For a given input string of words, create a function that returns the longest word in the string. For example, for the input phrase “I love Codecademy,” the output should be “Codecademy.”

For an added challenge, you can create an output that lists the longest word along with the number of characters in the word. So, for the string “I love Codecademy,” the output would look something like, “word: Codecademy count: 10.”*/

fun main() {
    val inputString = readln().split(' ').map { it }.toList()
    var bigIndex = 0

    for(index in 0 until inputString.size) {
        if(inputString[index].length > bigIndex) bigIndex = index
    }
    println("word: ${inputString[bigIndex]} count: $bigIndex")
}
