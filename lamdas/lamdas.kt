/*Range multiplication

Write a lambda expression that accepts two long arguments as range borders and returns the multiplication of all the numbers in this range (inclusively). Guaranteed that 0 <= left border <= right border. If left border == right border then the result is any border.

Note that you don't need to write in one line, you can use loops. */

val lambda: (Long, Long) -> Long = {
    a: Long, b: Long ->
    var result: Long = 1
    for (i in a..b) {
        result = result * i
    }
    if (a == b) result = a
    result
}

fun main() {
    println(lambda(2, 6))
}