import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val fileName = "D:/image.png"
    val imageFileDescriptor = File(fileName)
    val image = ImageIO.read(imageFileDescriptor)

    // Create a buffered image graphics instance
    val graphics = image.createGraphics()
    // Write image
    graphics.color = Color.RED
    graphics.drawPolygon(intArrayOf(10, 20, 30), intArrayOf(100, 20, 100), 3)
    // Save image
    ImageIO.write(image, "png", imageFileDescriptor)
}