import java.io.File

fun main() {
    val seperator = File.separator
    val fileName = "test.txt"
    val directoryPath = System.getProperty("user : dir")
    val qualifiledFileName = "$directoryPath$seperator$fileName"
    val file = File(fileName)
    val content = "sample********************* text"
    file.writeText(content.filter { it != '*' }) // filtering
//    repeat(10) {
//        file.appendText("Creation is undescribeable\n")
//    }
    file.forEachLine { println(it) }
}