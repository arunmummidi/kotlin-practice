import java.io.File
import javax.imageio.ImageIO
import java.awt.Color
import java.awt.image.BufferedImage

fun main() {
    val seperator = File.separator
    val inputFileName = "Kotlin_logo_wordmark.png"
    val directory = "D:$seperator"
    val fqFileName = "$directory$inputFileName"
    val file = File(fqFileName)

    val image: BufferedImage = ImageIO.read(file) // Read file as image using file descriptor

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            val color = Color(image.getRGB(x, y))
            val r = color.red
            val g = color.green
            val b = color.blue

            val colorNew = Color(r, g, 255)
            image.setRGB(x, y, colorNew.rgb)
        }
    }

    val outputFileName = "Kotlin_logo_wordmark_blue_grain.png"
    val fqOutputFileName = "$directory$outputFileName"
    val outputFile = File(fqOutputFileName)
    ImageIO.write(image,"png", outputFile)
}