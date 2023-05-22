package watermark

import java.awt.Color
import java.awt.Transparency
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO
import javax.imageio.IIOException
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.system.exitProcess

val seperator = File.separator
var waterMark: BufferedImage = ImageIO.read(File("D:${seperator}test.png"))
var image: BufferedImage = ImageIO.read(File("D:${seperator}test.png"))
val e = Exception()
var weight = 0

fun main() {
    println("Input the image filename:")
    val imageFile = readln()
    val imageFileDescriptor = File(imageFile)
    try {
        image = ImageIO.read(imageFileDescriptor)
    } catch (e: IIOException) {
        println("The file $imageFile doesn't exist.")
        exitProcess(1)
    }
    when {
        image.colorModel.numColorComponents != 3 -> {
            println("The number of image color components isn't 3.")
            exitProcess(1)
        }

        image.colorModel.pixelSize !in 24..32 -> {
            println("The image isn't 24 or 32-bit.")
            exitProcess(1)
        }
    }

    println("Input the watermark image filename:")
    val waterMarkFile = readln()
    val waterMarkFileDescriptor = File(waterMarkFile)
    try {
        waterMark = ImageIO.read(waterMarkFileDescriptor)
    } catch (e: IIOException) {
        println("The file $waterMarkFile doesn't exist.")
        exitProcess(1)
    }
    when {
        waterMark.colorModel.numColorComponents != 3 -> {
            println("The number of watermark color components isn't 3.")
            exitProcess(1)
        }
        waterMark.colorModel.pixelSize !in 24..32 -> {
            println("The watermark isn't 24 or 32-bit.")
            exitProcess(1)
        }
    }

    if (image.height != waterMark.height && image.width != waterMark.width) {
        println("The image and watermark dimensions are different.")
        exitProcess(1)
    }
    try {
        println("Input the watermark transparency percentage (Integer 0-100):")
        weight = readln().toInt()
        if (weight < 0 || weight > 100) {
            println("The transparency percentage is out of range.")
            exitProcess(1)
        }
    } catch (e: NumberFormatException) {
        println("The transparency percentage isn't an integer number.")
        exitProcess(1)
    }
    // Check if the image uses transparency property
    if (waterMark.transparency == Transparency.TRANSLUCENT) {
        println("Do you want to use the watermark's Alpha channel?")
        val useAlphaChannel = readln().lowercase()
        if(useAlphaChannel == "yes"){
            // use alpha channel and produce output image

            for (x in 0 until waterMark.width){
                for (y in 0 until waterMark.height){
                    val w = Color(waterMark.getRGB(x, y), true)
                    val i = Color(image.getRGB(x, y), true)
                    when(w.alpha) {
                        0 -> {
                            val o = i
                            image.setRGB(x, y, o.rgb)
                        }
                        255 -> {
                            val o = Color(
                                (weight * w.red + (100 - weight) * i.red) / 100,
                                (weight * w.green + (100 - weight) * i.green) / 100,
                                (weight * w.blue + (100 - weight) * i.blue) / 100
                            )
                            image.setRGB(x, y, o.rgb)
                        }
                    }
                }
            }
        }
    }

    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readln()
    val validFormat = outPutFileName.contains(".jpg") || outPutFileName.contains(".png")
    if (validFormat) {
        val outPutFileDescriptor = File(outPutFileName)
        for (x in 0 until waterMark.width){
            for (y in 0 until waterMark.height){
                image.setRGB(x, y, 255)
            }
        }
        ImageIO.write(image, "png", outPutFileDescriptor)
        println("The watermarked image $outPutFileName has been created.")

    } else {
        println("The output file extension isn't \"jpg\" or \"png\".")
        exitProcess(1)
    }
}