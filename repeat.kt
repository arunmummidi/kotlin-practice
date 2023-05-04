fun main() {
// Repeat function
    print("How many numbers to count:\n> ")
    val count = readln().toInt()
    var sum = 0

    repeat(count) {
        sum += readln().toInt()
    }
}