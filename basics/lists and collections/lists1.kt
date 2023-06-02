//You are given a List of integers. Iterate through the given List and print in a single line the elements that are divisible by 2.

fun main() {
    val inputNumbers = readln().split(' ').map { it.toInt() }.toMutableList()

    var listDivisibleBy2 = mutableListOf<Int>()
    for(element in 0 until inputNumbers.size ){
        if(inputNumbers[element] % 2 == 0) {
            listDivisibleBy2 += inputNumbers[element]
        }
    }

    println(listDivisibleBy2.joinToString(prefix = "", postfix = "", separator = " "))

}
