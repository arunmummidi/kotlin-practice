fun main () {
    var result = polynomial(1)
    println(result)
}

fun polynomial(x: Int = 0, c: Int = 0, b: Int = 0, a: Int = 0): Int {
    return a * x * x + b * x + c
}