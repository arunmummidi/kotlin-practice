import kotlin.math.*

fun main() {    
    val bit = 8.0 
    val short = 16.0
    val int = 32.0
    val long = 64.0

    val exp = 2.0 
    println((exp.pow(bit)-1).toInt())
    println((exp.pow(short)-1).toInt())
    println((exp.pow(int)-1).toInt())
    println((exp.pow(long)-1).toLong())
}
