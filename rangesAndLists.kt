fun main() {
// Ranges
    println(readln().toInt() !in 1..10)

//Lists
    var numbers = mutableListOf<Int>(12, 17, 8, 101, 33)

    val N = readln().toInt() // Read number of lines
    val integerArray = List(N) {readln().toInt()}
    val index = integerArray.size - 1
    var resultArray = mutableListOf<Int>() // Create an array to hold the output of calculation
    for (i in 0..8) {

        if (integerArray[i] <= integerArray[i+1]) {
            resultArray += integerArray[i]
        }
    }
    println(resultArray)

    var N = readln().toInt()
    var index = N - 1
    var inputList = List(N) { readln().toInt() }
    var count = 0
    var tempCount = 0

    var inputList = mutableListOf<Int>(1, 2 ,1, 1, 4 ,5)
}