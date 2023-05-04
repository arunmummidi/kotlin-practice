import java.util.Scanner
fun main() {
// For loop and ranges big probelm
    val index = readln().toInt() - 1
    val inputList = List(index + 1) { readln().toInt() }
    var tempCount = 0
    var count = 0

    for (i in 0..index) {
        if (i == index) {
            if (tempCount != 0) {
                if (inputList[i] >= inputList[i - 1]) {
                    ++count
                    println(count)
                    break
                }
            } else {
                println(count + 1)
                break
            }
        }
        if (inputList[i] <= inputList[i + 1]) {
            ++tempCount
            if (tempCount >= count) count = tempCount
        } else tempCount = 0
    }
}