import java.io.File
import java.security.MessageDigest
import java.util.*

val separator: String? = File.separator
val vcsRootDir = "vcs"
val vcsCommits = vcsRootDir + separator + "commits"
val vcsConfig = vcsRootDir + separator + "config.txt"
val vcsIndex = vcsRootDir + separator + "index.txt"
val vcsLog = vcsRootDir + separator + "log.txt"

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
        "log" -> showLog()
        "commit" -> if(args.size > 1) {
            commit(args[1].toString())
        }else {
            println("Message was not passed.")
        }
        "checkout" -> println("Restore a file.")
        "null" -> printHelpPage()
        else -> println("'$input' is not a SVCS command.")
    }
}


fun writeLog(commitId: String, message: String) {
    File(vcsLog).appendText("commit $commitId\n")
    File(vcsLog).appendText("Author: $commitId")
    File(vcsLog).appendText(message + "\n")
}

fun showLog() {
    if(File(vcsLog).readLines().size != 0) {
        println(File(vcsLog).readText())
    } else println("No commits yet.")
}

fun commit(message: String) {
    val commitID = UUID.randomUUID()
    val md = MessageDigest.getInstance("SHA-256")

    for(fileName in File(vcsIndex).readLines()) {
        var destinationFile = vcsCommits + separator + commitID + separator + fileName
        if(File(destinationFile).exists()){
            if(md.digest(File(fileName).readBytes()).contentEquals(md.digest(File(destinationFile).readBytes()))) {
                println("Nothing to commit.")
                break
            }
        }

        File(vcsCommits + separator + commitID).mkdir()
        File(fileName).copyTo(File(destinationFile))
    }

    println("Changes are committed.")
    writeLog(commitID.toString(), message)
}

fun createFileStructure() {
    if(!File(vcsRootDir).exists()) {
        File(vcsRootDir).mkdir()
        if (!File(vcsRootDir, "commits").exists()) {
            File(vcsCommits).mkdir()
        }
    }

    if(!File(vcsConfig).exists()) File(vcsConfig).createNewFile()
    if(!File(vcsIndex).exists()) File(vcsIndex).createNewFile()
    if(!File(vcsLog).exists()) File(vcsLog).createNewFile()
}

fun appendFileToIndex(fileName: String) {
    if(File(fileName).exists()) {
        if(File(vcsIndex).readText().contains(fileName)) {
            println("The file '$fileName' is tracked.")
            return
        }

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


