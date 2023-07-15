import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    // Image file attributes
    val seperator = File.separator
    val imageFileName = "image.png"
    val imageDirectory = "D:$seperator"
    val fqImageFile = "$imageDirectory$imageFileName"

    // Image attributes
    val height = 800
    val width = 800

    // Create image instance
    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)

    // Create image file instance
    val imageFile = File(fqImageFile)

    // Create buffered image; graphics instance
    val graphics = image.createGraphics()
    // Process buffered image - Write
    graphics.drawString("Hello world!", 80, 80)
    graphics.color = Color.PINK
    graphics.drawArc(200, 200, 100, 250, 45, 90)

    // Write the buffered image to file
    ImageIO.write(image, "png", imageFile)

}