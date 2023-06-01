/* Description

Before we can get to actually concealing a message in an image, we need to learn how to handle images. In this stage, we will work on the command hide.

For our purposes, the image has to be in a lossless format. "Lossless" implies that the pixel values don't change when the image is saved and compressed. We are going to work with the PNG image format. Other known formats such as JPG use lossy compression image format, which would corrupt the hidden message.

Images can be viewed as 2-dimensional arrays. In the picture below, you can see the image coordinate system:

image pixel coordinates

A 24-bit image offers more than 16 million colors for every pixel. If the RGB color scheme is used, then 8 bits (values 0–255) represent the Red, Green, and Blue colors. If the least significant bits of these 8-bit values change, the difference in the image will remain unnoticed. This is exactly what we will use for hiding our message in the next stages. In this stage, our program needs to set the least significant bit for each color of each pixel of the input image to the value 1.

24-bit rgb color bits

Java classes BufferedImage, ImageIO, and Color (java.awt.image.BufferedImage, javax.imageio.ImageIO, and java.awt.Color) should be used for reading/writing and changing the images.

With the BufferedImage class methods, the image pixels can be accessed as a 2-dimensional array. Also, note that the type BufferedImage.TYPE_INT_RGB should be used for 24-bit color with the BufferedImage class.

You may find it helpful to look at some examples of the BufferedImage, ImageIO, and Color classes.

Finally, I/O operations can easily fail. However, the program should not stop when an I/O exception occurs, for example, if a wrong input filename is given, so all I/O exceptions should be handled.
Objectives

When the user inputs the command hide, the program should prompt them for an input image filename with the message Input image file: and an output image filename with the message Output image file:. These should be used for reading the input image file and writing the output image file, respectively.

After reading the filenames, the program should print the following messages: Input Image: [input filename] and Output Image: [output filename].

When the input image is read, the least significant bit for each color (Red, Green, and Blue) is set to 1. The resulting image will be saved with the provided output image filename in the PNG format.

A proper method should be applied so that the I/O exceptions do not terminate the program. In such cases, an exception message should be printed and the program should return to the command loop.
Examples

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1: Normal execution.

Task (hide, show, exit):
> hide
Input image file:
> winter.png
Output image file:
> image.png
Input Image: winter.png
Output Image: image.png
Image image.png is saved.
Task (hide, show, exit):
> exit
Bye!

Example 2: Input file does not exist, an exception is caught.

Task (hide, show, exit):
> hide
Input image file:
> notexist.png
Output image file:
> image.png
Can't read input file!
Task (hide, show, exit):
> exit
Bye!
*/
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
