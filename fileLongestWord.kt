/* The longest word
There is a file that contains a sequence of words.
Download it and write a Kotlin program that finds the longest word in this file.
Enter the length of this word.*/

// Import File library
import java.io.File

fun main() {
    val seperator = File.separator // Set platform specific file seperator character '/' or '\'
    val fileName = "D:${seperator}words_sequence.txt"
    val file = File(fileName) // Take File descriptor in variable
    var size = 0
    file.forEachLine {
        // Try to convert string to Doube. If success, it is number.
        if (it.length > size) size = it.length
    } // Invoke forEachLine method on the file descriptor
    println(size)
}