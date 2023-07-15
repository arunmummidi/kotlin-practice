import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.awt.image.IndexColorModel
import java.io.File
import javax.imageio.ImageIO

fun main() {
    // Add your code here
    // Create a file descriptor
    val fileName = "D:/arun.png"
    val fileDescriptor = File(fileName)

    // Create a Buffer image descriptor
    val image = BufferedImage(300, 300, TYPE_INT_RGB)

    // Create a Buffer image graphics descriptor
    val graphics: Graphics = image.createGraphics()
    graphics.color = Color.YELLOW

    // Draw an image to the buffer image
    graphics.drawPolygon(
        intArrayOf(50, 100, 200, 250, 200, 100),
        intArrayOf(150, 250, 250, 150, 50, 50),
        6
    )

    // Save image
    ImageIO.write(image, "png", fileDescriptor)
    return
}