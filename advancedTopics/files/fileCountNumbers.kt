/*Counting numbers in a file
There is a file that contains a sequence of words and numbers.
Download it and write a Kotlin program that counts only numbers in this file.
Enter the result.*/

import java.io.File

fun main() {
    val seperator = File.separator // Set platform specific file seperator character '/' or '\'
    val fileName = "${seperator}tmp${seperator}words_with_numbers.txt"
    val file = File(fileName) // Instantiate the file descriptor

    var count = 0
    file.forEachLine {  // Invoke forEachLine method on the file descriptor
        // Try to convert string to Doube. If success, it is number.
        if (it.toDoubleOrNull() != null) {
            count++
        }
    }
    println(count)
}
