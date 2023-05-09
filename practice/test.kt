import java.io.File

fun main() {
    println("hello world!")
    val fileName = "D:/test.txt"
    val file = File(fileName)
    print(file.readText())
}
