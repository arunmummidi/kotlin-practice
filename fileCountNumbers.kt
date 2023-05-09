/*Count the numbers
There is a file that contains a sequence of words and numbers.
Download it and write a Kotlin program that counts only numbers in this file.
Enter the result.*/

// Import File library
import java.io.File

fun main() {
    val seperator = File.separator // Set platform specific file seperator character '/' or '\'
    val fileName = "D:${seperator}words_with_numbers.txt"
    val file = File(fileName) // Take File descriptor in variable
    var count = 0
    file.forEachLine {
        // Try to convert string to Doube. If success, it is number.
        if (it.toDoubleOrNull() != null) {
            count++
        }
    } // Invoke forEachLine method on the file descriptor
    println(count)
}