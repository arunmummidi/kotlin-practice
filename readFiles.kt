import java.io.File

fun main() {
    val fileName = "D:/test.txt"
    val lines = File(fileName).readText()
    print(lines)
}