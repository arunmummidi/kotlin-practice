import java.io.File

fun main() {
    val seperator = File.seperator
    val fileName = "D:" + seperator + "test.txt"

    val lines = File(fileName).readText()
    print(lines)

    val file = File(fileName)
    val lines1 = file.readText(Charsets.US_ASCII)
    print(lines1)

    val fileName2 = "D:" + seperator + "temp.txt"
    val file2 = File(fileName2)
    if (file2.exists()) {
        file2.readText()
    }else println("File doesn't exist")
}
