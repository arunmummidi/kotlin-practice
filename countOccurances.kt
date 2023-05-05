/*Write a program that counts the times a number M occurs in N numbers.

The first line contains the N number.
The next N lines contain the numbers.
The last line contains the M number.

Output only a single non-negative integer number.*/
fun main() {
    var integerList: MutableList<Int> = mutableListOf()
    for (i in 1.. readln().toInt()) {
        integerList.add(readln().toInt())
    }
    var toMatch = readln().toInt()
    var count = 0
    for (i in 0 until integerList.size) {
        if (integerList[i] == toMatch) count++
    }
    println(count)
}