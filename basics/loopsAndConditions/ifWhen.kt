
fun main() {
//If statement
    if (true) {
        print(message = "You are correct")
    } else {
        print(message = "You are wrong!")
    }

//When statement
    val mercury = "Mercury"
    when (mercury) {
        "mercury" -> print(message = "Universe is intact")
        "Mercury" -> print(message = "Universe is still intact")
        else -> print(message = "Universe may be in danger")
    }

    var age = 40
    var hasAccess: Boolean = true
    when {
        age < 18 && hasAccess -> println("False positive")
        age > 21 && !hasAccess -> println("False negative")
        else -> println("All working as expected")
    }
    val maxSurfaceTempInK = 700
    when (maxSurfaceTempInK) {
        700 -> println("This is Mercury's maximum surface temperature") // 1
        0, 1, 2 -> println("It's as cold as it gets") // 2
        in 300..699 -> println("This temperature is also possible on Mercury") // 3
        !in 0..300 -> println("This is pretty hot") // 4
        is Int -> println("Given variable is of type Int") // 6
        else -> { // 7
            // You can also use blocks of code on the right hand side, like here
            println("Default case")
        }
    }
}