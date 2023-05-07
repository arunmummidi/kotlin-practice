/*
copy() usage

Write a program that reads four numbers (height, twice length, width) and uses all of them as fields of a data class which is Box.

Use copy() function in order to create a second box with a different length value (from input). As a result, there must be two boxes. Print them both.
Sample Input 1:

3
4
1
9

Sample Output 1:

Box(height=3, length=4, width=9)
Box(height=3, length=1, width=9)*/

// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    // implement your code here
    var box1 = Box(height = readln().toInt(), length = readln().toInt(), width = 0)
    val box2 = box1.copy(length = readln().toInt(), width = readln().toInt())
    box1 = box1.copy(width = box2.width)
    println(box1)
    println(box2)
}