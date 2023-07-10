/*You have two strings from standard input:
the first one is a sequence of numbers,
and the second is one number.
Create a number list from the first string
and return the element with the index equal
to the number from the second string.
Return null if there isn't such an element in the list.*/

fun main() {
    val myList = readln().split(' ').map { it.toInt() }
    val index = readln().toInt()
    println(myList.getOrNull(index))
}
