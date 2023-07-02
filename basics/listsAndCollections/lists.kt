fun main() {
// String concatination
    val firstList = readLine()!!.split(' ').map { it }.toMutableList()
    val secondList = readLine()!!.split(' ').map { it }.toMutableList()
    // do not touch the lines above
    // write your code here
    println(firstList.joinToString() + secondList.joinToString())

// Two dimensional String List manipulations
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    val finalString: MutableList<MutableList<String>> = mutableListOf()
    finalString.add(inputList.last())
    finalString.add(inputList.first())
    println(finalString)

// Three dimensional String Lists manipulation
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val stringsList = readLine()!!.split(' ').toMutableList()
        inputList.add(stringsList)
    }
    println(inputList[2].joinToString(separator = ", "))

// Multi dimentional arrays 3x3x3
    val intList: MutableList<MutableList<MutableList<Int>>> = mutableListOf(
        mutableListOf(
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0)
        ),
        mutableListOf(
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0)
        ),
        mutableListOf(
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0),
            mutableListOf(0, 0, 0)
        )
    )
    println(intList)
}
