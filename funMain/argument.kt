fun main(args: Array<String>) {
    val input = args.firstOrNull()
        when(input) {
            null, "--help" -> printHelpPage()
            "config" -> println("Get and set a username.")
            "add" -> println("Add a file to the index.")
            "log" -> println("Show commit logs.")
            "commit" -> println("Save changes.")
            "checkout" -> println("Restore a file.")
            "null" -> printHelpPage()
            else -> println("'${input.toString()}' is not a SVCS command.")
        }
}

fun printHelpPage() {
    println("""
        These are SVCS commands:
        config     Get and set a username.
        add        Add a file to the index.
        log        Show commit logs.
        commit     Save changes.
        checkout   Restore a file.
    """.trimIndent())
}
