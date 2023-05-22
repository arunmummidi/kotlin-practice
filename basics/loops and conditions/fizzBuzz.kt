fun main() {
//    FizzBuzz
    val lowestNumber = readln().toInt()
    val highestNumber = readln().toInt()
    for (i in lowestNumber .. highestNumber) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else {
            if (i %3 == 0) {
                println("Fizz")
            } else {
                if (i % 5 == 0) {
                    println("Buzz")
                } else println(i)
            }
        }
    }
}