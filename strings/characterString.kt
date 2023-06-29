/*Unique characters:
Write a function that takes a CharSequence as input and returns the number of unique characters in the sequence.*/

fun main() {
    val count = countUniqueChars("bacaaa")
    println(count)
}

fun countUniqueChars(sequence: CharSequence): Int {
    // write your code here
    return sequence.toSet().size
}
