/*Sum of values

You are given Map<Int, Int> as input. Return the sum of all values that have even keys.

Sample Input 1:

{100 to 10}, {55 to 3}, {112 to 5}

Sample Output 1:

15*/

fun main() {
    summator(mapOf(100 to 10, 55 to 3, 112 to 5))
}

fun summator(map: Map<Int, Int>): Int {
    var sum = 0
    for((k, v) in map) {
        if(k % 2 == 0) {
            sum += v
        }
    }
    return  sum
}
