fun main() {
// Logical operators and conditionals
    val scanner = Scanner(System.`in`)
    var count = scanner.nextInt()
    var highestNumber =0
    while (count != 0) {
        var value = scanner.nextInt()
        var reminder = value % 4
        if (reminder == 0 && value > highestNumber) highestNumber = value
        count--
    }
    println(highestNumber)
}