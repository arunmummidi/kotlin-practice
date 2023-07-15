fun main() {
// Safe call and elvis operators:

// !! This operator is used to stop the program when null is met.

val nullString: String? = null
println(nullString?.length)    // null
val emptyString: String? = ""
println(emptyString?.length)   // 0

val nullString: String? = null
println(nullString?.length ?: -1)   // -1
val emptyString: String? = ""
println(emptyString?.length ?: -1)  // 0

    val string = "hello world"
    println(string.length)
    readlnOrNull() ?: error("Input is not entered")

    var x: String? = null
    x = x ?: "Hello"
    println(x) // "Hello"

    val nullString: String? = null
    print(nullString?.isNotEmpty() == true) // false

    val nullString: String? = null
    println(nullString?.isNotEmpty() ?: false) // false

    val b: Boolean? = ...
    if (b == true) {
        ...
    } else {
        // `b` is false or null
    }

    readlnOrNull() ?: error("No lines read")

    val nullString: String? = null
    println(nullString?.length ?: -1)   // -1
    val emptyString: String? = ""
    println(emptyString?.length ?: -1)  // 0

    val nullString: String? = null
    println(nullString?.length)    // null
    val emptyString: String? = ""
    println(emptyString?.length)   // 0

    val line: String = readlnOrNull() ?: throw IllegalStateException()
    println("Elvis says: $line")

    val age: Int? = null
    val name: String? = "Bob"
    val nickname: String? = null
    val length: Int = nickname?.length ?: 0
    println("$age ${name?.length} $length")
}