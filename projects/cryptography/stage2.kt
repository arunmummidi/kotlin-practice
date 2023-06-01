package cryptography
import java.awt.Color
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

var inputFile = ""
var outputFile = ""
val e = Exception()

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
                hideDataInImage()
            } catch (e: Exception) {
                showMenu()
            }
        }
        "show" -> {
            println("Obtaining message from image.")
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

fun hideDataInImage() {
    val image = ImageIO.read(File(inputFile))

    for (width in 0 until image.width) {
        for(height in 0 until image.height) {
            var imageColor = Color(image.getRGB(width, height))
            val redColor = imageColor.red or 1
            val greenColor = imageColor.green or 1
            val blueColor = imageColor.blue or 1
            val transformedColor = Color(redColor, greenColor, blueColor, TYPE_INT_RGB)

            image.setRGB(width, height, transformedColor.rgb)
        }
    }

    ImageIO.write(image, "png", File(outputFile))
    println("Image $outputFile is saved.")
}
