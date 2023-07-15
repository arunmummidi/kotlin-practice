import java.io.File

fun main() {
    val seperator = File.separator
    val directory = System.getProperty("user.dir") // Set directory to current directory
    val fileName = "$directory${seperator}wite.txt"
    val file = File(fileName)
    file.writeText("Hello world\n How are you") // Write to file
    file.forEachLine { println(it) }
    println(System.getProperty("user.dir")) // Get current directory
}