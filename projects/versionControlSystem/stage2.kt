import java.io.File

var fileList = emptyList<String>()
val separator = File.separator
val vcsRootDir = "vcs"
val vcsConfig = vcsRootDir + separator + "config.txt"
val vcsIndex = vcsRootDir + separator + "index.txt"

fun main(args: Array<String>) {
    createFileStructure()
    when(val input = args.firstOrNull()) {
        null, "--help" -> printHelpPage()
        "config" -> {
            if(args.size > 1){
                config(args[1].toString())
            } else config()
        }
        "add" -> {
            if(args.size > 1) {
                appendFileToIndex(args[1].toString())
            } else {
                showFiles()
            }
        }
        "log" -> println("Show commit logs.")
        "commit" -> println("Save changes.")
        "checkout" -> println("Restore a file.")
        "null" -> printHelpPage()
        else -> println("'${input.toString()}' is not a SVCS command.")
    }
}

fun createFileStructure() {
    if(!File(vcsRootDir).exists()) {
        File(vcsRootDir).mkdir()
    }

    if(!File(vcsConfig).exists()) File(vcsConfig).createNewFile()
    if(!File(vcsIndex).exists()) File(vcsIndex).createNewFile()
}

fun appendFileToIndex(fileName: String) {
    if(File(fileName).exists()) {
        val fileDescriptor = File(vcsIndex)
        fileDescriptor.appendText("$fileName\n")
        println("The file '$fileName' is tracked.")
    } else {
        println("Can't find '$fileName'.")
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

fun config(userName: String) {
    println("The username is $userName.")
    val fileDescriptor = File(vcsConfig)
    fileDescriptor.writeText(userName)
}

fun config() {
    if(File(vcsConfig).readBytes().isEmpty()) {
        println("Please, tell me who you are.")
    } else println("The username is ${File(vcsConfig).readText().toString().trim('\n')}.")
}

fun showFiles() {
    if(File(vcsIndex).readText().isEmpty()) {
        println("Add a file to the index.")
    } else {
        println("Tracked files:")
        val indexFile = File(vcsIndex)
        val charArray = indexFile.readText()
        println(charArray)
    }
}
