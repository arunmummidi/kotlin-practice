fun main() {
    // Basic printing
    print(message = "Hello world")
    // Read only immutable variables called values
    val arun: String = "Male"

    // Basic variable declaration and assignment
    val counter = 100
    print(counter)
    print(arun)

//printing and strings
    println("\u001B[32mWE\u001B[0m \u001B[34mNEED\u001B[0m\n\n\u001B[32mTO\u001B[0m \u001B[34mLEARN\u001B[0m \u001B[32mKOTLIN\u001B[0m\n\n\u001B[34mAS\u001B[0m \u001B[32mQUICKLY\u001B[0m \u001B[34mAS POSSIBLE\u001B[0m")

    for (i in 1..7){
        println("#")
    }
// Strings
    println("\nEat sleep Code repeat".repeat(7))
    print("""
        Hello world....
        Meowy
    """.trimIndent())

    print("""
        {
            "firstName": "John",
            "lastName": "Smith",
            "age": 35,
            "phoneNumbers": [
                {
                    "type": "mobile",
                    "number": "123 567-7890"
                }
            ]
        }""".trimIndent())

// Process expressions in print
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    scanner.close()
    val length = input.length
    print("${input.length} repetitions of the word $input: ${input.repeat(length)}")

}