package svcs

import java.io.File
import java.io.FileWriter
import java.security.MessageDigest
import java.util.*

val md: MessageDigest = MessageDigest.getInstance("SHA-256")
val separator: String? = File.separator
const val vcsRootDir = "vcs"
val vcsCommits = vcsRootDir + separator + "commits"
val vcsConfig = vcsRootDir + separator + "config.txt"
val vcsIndex = vcsRootDir + separator + "index.txt"
val vcsLog = vcsRootDir + separator + "log.txt"
val vcsLogTemp = vcsRootDir + separator + "log_temp.txt"
var currentCommitID = ""

fun main(args: Array<String>) {
    createFileStructure()
    when(val input = args.firstOrNull()) {
        "null", null, "--help" -> printHelpInfo()
        "config" -> {
            if(args.size > 1){
                writeConfig(args[1])
            } else showConfig()
        }
        "add" -> {
            // Append file name to index file if add invoked with file name
            if(args.size > 1) {
                addFileToStaging(args[1])
            } else {
                // If add invoked with no arguments, show the added files
                showStagedFiles()
            }
        }
        "log" -> showLog()
        "commit" -> if(args.size > 1) {
            if(hasNewChanges() == "changed") {
                commit(args[1])
            } else println("Nothing to commit.")
        }else {
            println("Message was not passed.")
        }
        "checkout" -> {
            if(args.size > 1) {
                checkout(args[1])
            } else println("Commit id was not passed.")
        }
        else -> println("'$input' is not a SVCS command.")
    }
}

fun checkout(commitId: String) {
    if(File(vcsCommits + separator + commitId).exists()) {
        for(selectedVersion in File(vcsCommits + separator + commitId).listFiles()!!) {
            selectedVersion.copyTo(File(selectedVersion.name), overwrite = true)
        }
        println("Switched to commit $commitId.")
    } else println("Commit does not exist.")
}

fun hasNewChanges(): String {
    if(File(vcsLog).readText().isNotEmpty()){
        val lastCommitDirectory = File(vcsLog).readText().substringAfter(' ').substringBefore('\n')
        val files = File(vcsCommits + separator + lastCommitDirectory).listFiles()

        for(committedFile in files!!) {
            for(sourceFile in File(vcsIndex).readLines()) {
                if(sourceFile == committedFile.name){
                    if(!md.digest(File(sourceFile).readBytes()).contentEquals(md.digest(committedFile.readBytes()))) {
                        return "changed"
                    }
                }
            }
        }
        return "not changed"
    } else return "changed"
}

fun writeLog(commitId: String, message: String) {
    val authorName = File(vcsConfig).readText()

    FileWriter(vcsLog, false).use{it.write("commit $commitId\nAuthor: $authorName\n$message\n\n" + File(vcsLogTemp).readText())}
//    FileWriter(svcs.getVcsLogTemp, false).use{it.write(File(svcs.getVcsLogTemp).readText())}
    File(vcsLog).copyTo(File(vcsLogTemp), overwrite = true)
}

fun showLog() {
    if(File(vcsLog).readLines().isNotEmpty()) {
        println(File(vcsLog).readText())
    } else println("No commits yet.")
}

fun commit(message: String) {
    val commitID = UUID.randomUUID()

    for(fileName in File(vcsIndex).readLines()) {
        val destinationFile = vcsCommits + separator + commitID + separator + fileName

        File(vcsCommits + separator + commitID).mkdir()
        File(fileName).copyTo(File(destinationFile))
    }

    println("Changes are committed.")
    writeLog(commitID.toString(), message)
    currentCommitID = commitID.toString()
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
    if(!File(vcsLogTemp).exists()) File(vcsLogTemp).createNewFile()
}

fun addFileToStaging(fileName: String) {
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

fun printHelpInfo() {
    println("""
        These are SVCS commands:
        config     Get and set a username.
        add        Add a file to the index.
        log        Show commit logs.
        commit     Save changes.
        checkout   Restore a file.
    """.trimIndent())
}

fun writeConfig(userName: String) {
    println("The username is $userName.")
    val fileDescriptor = File(vcsConfig)
    fileDescriptor.writeText(userName)
}

fun showConfig() {
    if(File(vcsConfig).readBytes().isEmpty()) {
        println("Please, tell me who you are.")
    } else println("The username is ${File(vcsConfig).readText().trim('\n')}.")
}

fun showStagedFiles() {
    if(File(vcsIndex).readText().isEmpty()) {
        println("Add a file to the index.")
    } else {
        println("Tracked files:")
        val indexFile = File(vcsIndex)
        val charArray = indexFile.readText()
        println(charArray)
    }
}
