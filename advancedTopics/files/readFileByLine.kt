// Import File library
import java.io.File

fun main() {
    val seperator = File.separator // Set platform specific file seperator character '/' or '\'
    val fileName = "D:${seperator}test.txt"
    val file = File(fileName) // Take File descriptor in variable
    file.forEachLine { println(it) } // Invoke forEachLine method on the file descriptor
}