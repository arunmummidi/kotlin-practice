//https://www.codecademy.com/resources/blog/kotlin-code-challenges-for-beginners/
/*1. Number steps

Many programming languages have built-in functions that output sequences of numbers separated by steps. Create your own Kotlin function from scratch that creates a sequenced list of numbers from 0 to a maximum input value and input step. For example, a maximum value of 8 and a step value of 2 should return an output of [2, 4, 6, 8].

If you’re looking for more of a challenge, create a Fibonacci sequence generator. Remember that the following number of a Fibonacci sequence is the sum of the two preceding it: [1, 1, 2, 3, 5, 8, 13].*/


import java.lang.IndexOutOfBoundsException

val e = Exception()
fun main() {
    sequenceWithStep(readln())
}

fun sequenceWithStep(arguments: String){
    try {
        var argumentList = arguments.split(' ').map { it.toInt() }.toList()
        var numberList = listOf<Int>()

        for (element in argumentList[1] until argumentList[0] step argumentList[1]) {
            numberList += element
        }

        println(numberList.joinToString(prefix = "[", postfix = "]"))

    } catch (e: NumberFormatException) {
        println(e.message)
        println("Invalid input provided. Please try again.")
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
        println("Invalid input provided. Please try again.")
    } finally {
        sequenceWithStep(readln())
    }
}
