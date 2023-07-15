/*Cyclically shifting elements
Write a program that reads an A array of integers and cyclically shifts the elements of the array to the right: A[0] goes to the place of A[1], A[1] becomes A[2], ..., and the last element goes to the place of A[0]).

The first line of the input contains the number of elements in the array.
The other lines contain the elements of the array.

The output contains all the shifted elements of the array in a single line. Separate the elements by one space character.*/

import java.util.*

fun main() {
    var numberArray = IntArray(readln().toInt())

    for (i in 0 until numberArray.size) {
        numberArray[i] = readln().toInt()
    }
    val numberList = numberArray.toList()
    Collections.rotate(numberList, 1)

    println(numberList.toIntArray().joinToString().replace(", ", " "))
}
