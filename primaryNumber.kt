import kotlin.system.exitProcess

fun printIfPrime(number: Int) {
    var divisors = 0
    for(numberSequence in 2 .. number){
        if(number % numberSequence == 0) {
            divisors++
        }
    }
    if(divisors == 1) {
        println("$number is a prime number.")
        return
    }

    println("$number is not a prime number.")
}

fun main(args: Array<String>) {
    printIfPrime(readln().toInt())
}
