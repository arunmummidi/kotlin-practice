/*You have a function that takes a name and a few other arguments and returns a greeting.

Implement a greetNeo() function that returns Hello, Mr. Anderson. Use the greetUser() function with correct arguments.*/

fun main() {
    greetNeo()
}

fun greetUser(
    name: String,
    admin: Boolean = false,
    smith: Boolean = false,
    honorific: String = "",
    greet: String = "Greetings"
): String {
    return if (!admin && !smith) {
        "$greet, $honorific $name"
    } else {
        "Matrix Error"
    }
}
// do not change lines above        

//fun greetNeo() = println(greetUser(name = "Mr. Anderson", greet = "Hello"))
fun greetNeo(): String{
    val stringOutput = greetUser(name = "Anderson", honorific = "Mr.", greet="Hello")
    println(stringOutput)
    return stringOutput
}
