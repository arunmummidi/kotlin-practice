package cryptography
import java.awt.Color
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO
import kotlin.experimental.and
import kotlin.system.exitProcess

var inputFile = ""
var outputFile = ""
val e = Exception()
var encodedMessage: ByteArray = "sample".encodeToByteArray()

fun main() {
    while (true) showMenu()
}

fun showMenu() {
    println("Task (hide, show, exit):")
    when(readln()) {
        "exit" -> {
            println("Bye!")
            exitProcess(0)
        }
        "hide" -> {
            try {
                readFileNames()
                readMessage()
                hideDataInImage()
            } catch (e: Exception) {
                showMenu()
            }
        }
        "show" -> {
            decryptMessage()
            showMenu()
        } else -> {
        println("Wrong task: [input String]")
        showMenu()
    }
    }
}

fun readFileNames() {
    println("Input image file:")
    inputFile = readln()
    println("Output image file:")
    outputFile = readln()

    if (!File(inputFile).exists()) {
        println("Can't read input file!")
        showMenu()
    }

    if (!File(outputFile).exists()) {
        println("Can't read output file!")
        showMenu()
    }

    println("Input Image: $inputFile")
    println("Output Image: $outputFile")
}

fun readMessage() {
    println("Message to hide:")
    val inputMessage = readln()
    encodedMessage = inputMessage.encodeToByteArray()
    encodedMessage += 0
    encodedMessage += 0
    encodedMessage += 3

    // Check if image size is adequate to store the message
    val image = ImageIO.read(File(inputFile))

    val availableBytes = ((image.width * image.height) / 8) - 3
    if (encodedMessage.size >= availableBytes) {
        println("The input image is not large enough to hold this message.")
        showMenu()
    }
}

fun hideDataInImage() {
    val image = ImageIO.read(File(inputFile))

    for (x in 0 until image.width) {
        for(y in 0 until image.height) {
            var imageColor = Color(image.getRGB(x, y))
            val blueColor = imageColor.blue or 1
            val transformedColor = Color(imageColor.red, imageColor.green, blueColor, TYPE_INT_RGB)

            image.setRGB(x, y, transformedColor.rgb)
        }
    }

    ImageIO.write(image, "png", File(outputFile))
    println("Message saved in $outputFile image.")
}

fun decryptMessage() {
    println("Input image file:")
    val outputImage = ImageIO.read(File(outputFile))
    var byte = emptyArray<Byte>()
    for (x in 0 until outputImage.width) {
        for(y in 0 until outputImage.height) {
            var imageColor = Color(outputImage.getRGB(x, y))
            val blueColor = imageColor.blue
//            print(blueColor)
            val one = 1
            byte += blueColor.toByte() and one.toByte()
        }
    }

    println(byte)
    println("Message:")
}
