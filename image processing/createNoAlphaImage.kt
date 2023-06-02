import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val separator = File.separator
    val file = File("${separator}home${separator}arun${separator}Downloads${separator}test1.png")
    file.createNewFile()
    val image = BufferedImage(200, 200, TYPE_INT_RGB)

    val color = Color(101, 189, 89)


    for(width in 0 until image.width) {
        for(height in 0 until image.height) {
            image.setRGB(width, height, color.rgb)
        }
    }
    ImageIO.write(image, "png", file)
}
