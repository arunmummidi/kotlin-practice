/*Generate ARGB value
Write the code for the function printARGB(). It reads 4 integers from stdin divided by spaces. They denote the Alpha, Red, Green, and Blue values respectively, and each should be in the range 0-255.
If any value is out of range, then the function should print "Invalid input".
If everything is within range, then a Color instance should be created with the provided data and its ARGB value should be printed.
Note that the ARGB value is a 32-bit integer. If printed as it is, you may get a negative value. In order to avoid this, the ARGB value should first be converted to Unsigned Integer (UInt).

Sample Input 1:
0 128 128 128
Sample Output 1:
8421504*/

import java.awt.Color

fun printARGB() {
    val inputList = readln().split(' ')
    if (inputList.size > 4) {
        println("Invalid input")
        return
    }

    val integerList = mutableListOf<Int>()
    for (index in 0 until inputList.size) {
        when (inputList[index].toInt()) {
            in 0..255 -> integerList.add(index, inputList[index].toInt())
            else -> {
                println("Invalid input")
                return
//                throw Exception(" Invalid Input")
            }
        }
    }
    val alpha = integerList[0]
    val red = integerList[1]
    val green = integerList[2]
    val blue = integerList[3]

    val color = Color(red, green, blue, alpha)
    println(color.rgb.toUInt())

}

fun main() {
    printARGB()
}