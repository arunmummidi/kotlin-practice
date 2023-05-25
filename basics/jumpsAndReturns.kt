// Write a program that reads a combination of letters and numbers and prints the first digit in it. It is guaranteed that there is at least one digit in the combination.
// Jumps and returns

fun main() {
    // put your code here
    val inputString = readln()
    for(index in 0 until inputString.length) {
        when(inputString[index]) {
            in '0'..'9' -> {
                println(inputString[index])
                break
            }
        }
    }
}