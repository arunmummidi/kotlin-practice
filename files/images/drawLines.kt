import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO

fun main() {
    // Create a file instance
    val fileName = "d:/lines.png"
    val file = File(fileName)

    // Create a buffered image instance
    val image = BufferedImage(200, 200, TYPE_INT_RGB)

    // Create a buffered image graphics instance
    val graphics = image.createGraphics()
    // Set color to RED
    graphics.color = Color.RED
    // Draw a line using graphics instance
    graphics.drawLine(0, 0, 200, 200)

    // Draw a green line
    graphics.color = Color.GREEN
    graphics.drawLine(200, 0, 0, 200)

    ImageIO.write(image, "png", file)
}