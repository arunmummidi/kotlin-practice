un main() {
    val bit = 8.0
    val short = 16.0
    val int = 32.0
    val long = 64.0

    val exp = 2.0
    println((exp.pow(bit)-1).toInt())
    println((exp.pow(short)-1).toInt())
    println((exp.pow(int)-1).toInt())
    println((exp.pow(long)-1).toLong())

// Printing max value of a datatype
    val byte: Byte = Byte.MAX_VALUE
    val short1: Short = Short.MAX_VALUE
    val int1: Int = Int.MAX_VALUE
    val long1: Long = Long.MAX_VALUE
    print("$byte\n$short1\n$int1\n$long1")
}

