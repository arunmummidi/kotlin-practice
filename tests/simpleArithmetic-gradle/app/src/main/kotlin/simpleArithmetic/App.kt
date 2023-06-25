package simpleArithmetic

fun main() {
    addNumbers(1, 2)
    subtractNumbers(4, 1)
    multiplyNumbers(2, 2)
    isEven(4)
    println("Hello from gradalized app")
}

fun addNumbers(integer1: Int, integer2: Int): Int {
    return integer1 + integer2
}

fun subtractNumbers(integer1: Int, integer2: Int): Int {
    return integer1 - integer2
}

fun multiplyNumbers(integer1: Int, integer2: Int): Int {
    return integer1 * integer2
}

fun isEven(integer1: Int): Boolean {
    if(integer1 % 2 == 0) {
        return true
    } else return false
}
