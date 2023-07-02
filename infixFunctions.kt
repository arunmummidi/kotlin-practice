//infix functions

infix fun String.arun_fun(string1: String): Boolean {
    return this == string1
}

fun main() {
    val total = sum(1,3)
    println(total)
    val str1 = "Hello"
    val str2 = "Hello"
    val result = str1 arun_fun str2
    println(result)
}
