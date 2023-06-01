/*A steganography/cryptography program is versatile: it can perform a variety of tasks based on the user's wishes. You may want to hide a message within an image, encrypt the text message for extra security, or decipher a hidden message you got from someone else.

In this stage, you will create the user interface for your program. The user will be able to choose a task by giving commands via standard input.
Objectives

The program should read input strings (commands) in a loop.

Your program should:

Print the message Task (hide, show, exit): and read standard input in a loop.
If the input is exit, print Bye! and exit.
If the input is hide, print Hiding message in image. and return to the input loop.
If the input is show, print Obtaining message from image. and return to the input loop.
If any other string is input, then print Wrong task: [input String] and return to the input loop.*/

package cryptography
import kotlin.system.exitProcess

fun main() {
    while (true) readInput()
}

fun readInput() {
    println("Task (hide, show, exit):")
    when(readln()) {
        "exit" -> {
            println("Bye!")
            exitProcess(0)
        }
        "hide" -> {
            println("Hiding message in image.")
            readInput()
        }
        "show" -> {
            println("Obtaining message from image.")
            readInput()
        } else -> {
            println("Wrong task: [input String]")
            readInput()
        }
    }
}

