/*Write a program that reads a color name and prints the position of this color in the rainbow, starting with 1.*/

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun main() {
    val color = readln()
    val colorList = Rainbow.values()
    for(index in colorList.indices) {
        if (colorList[index].toString() == color.uppercase()) {
            println(index +1)
        }
    }
}

