/*Your function receives two sets of Int. Return a new set of elements in the first set that are multiples of the size of the second set.*/
fun solution(first: Set<Int>, second: Set<Int>): Set<Int> {
    val third = mutableSetOf<Int>()
    for (dividend in first) {
        if(dividend % second.size == 0) third += dividend
    }

    return third
}

fun main() {
    val first = setOf(2, 4, 3, 6, 33)
    val second = setOf(1, 2)
    println(solution(first, second))
}
