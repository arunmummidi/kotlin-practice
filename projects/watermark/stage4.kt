package watermark

/*Description

If a watermark image doesn't use the alpha channel, we can treat a specific color as a transparent one. For example, if a watermark image logo has a white background, the white color can be handled as transparent. If watermark logo pixels are of the same color as its background, treat them as transparent.

If your watermark image doesn't have the alpha channel, you will be prompted to choose a specific color as transparency.
Objectives

If a watermark image has the alpha channel, proceed as in the previous stage (Examples 2 and 3);
Otherwise, before asking users for the watermark transparency percentage, output Do you want to set a transparency color?. If the user inputs anything else than yes, proceed without the use of a transparency color (Example 4);
If the input is yes, ask for the transparency color with Input a transparency color ([Red] [Green] [Blue]):. After this, users should input 3 integer numbers, each within the 0 to 255 range, separated by space(Example 1). These are the values for the red, green, and blue colors, respectively. Any pixels in the watermark image with this color, should be treated as transparent. In case the input isn't correct, print The transparency color input is invalid. and terminate the program (Example 5).

If you need some image files to experiment with your code for stage 4, then you can download this zip file.*/

// stage 4 - Transparency color

import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.*
import java.io.File
import java.lang.IndexOutOfBoundsException
import javax.imageio.ImageIO
import javax.imageio.IIOException
import kotlin.system.exitProcess

var weight: Int = 0
var imageFile = ""
var waterMarkFile = ""
var useAlpha = "no"
var transparencyRed = 0
var transparencyGreen = 0
var transparencyBlue = 0
val e = Exception()

fun main() {
    println("Input the image filename:")
    imageFile = readln()
    sanityCheck(imageFile, "image")

    println("Input the watermark image filename:")
    waterMarkFile = readln()
    sanityCheck(waterMarkFile, "watermark")

    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    if (image.height != waterMark.height && image.width != waterMark.width) {
        println("The image and watermark dimensions are different.")
        exitProcess(1)
    }

    if(waterMark.transparency == TRANSLUCENT) {
        println("Do you want to use the watermark's Alpha channel?")
        useAlpha = readln().lowercase()
        // use alpha channel and produce image
        readWaterMarkTransparency()
        createWaterMark()
        exitProcess(0)
    } else {
        println("Do you want to set a transparency color?")
        val useTransparency = readln().toString().lowercase()
        if(useTransparency == "yes") {
            println("Input a transparency color ([Red] [Green] [Blue]):")
            val inputString = readln().split(' ')

            try {
                if (inputString.size != 3) {
                    println("The transparency color input is invalid.")
                    exitProcess(1)
                }
                for(value in inputString) {
                    if (value.toInt() !in 0..255) {
                        println("The transparency color input is invalid.")
                        exitProcess(1)
                    }
                }
                transparencyRed = inputString[0]?.toInt()
                transparencyGreen = inputString[1]?.toInt()
                transparencyBlue = inputString[2]?.toInt()
            } catch (e: Exception) {
                when(e) {
                    is IndexOutOfBoundsException, is NumberFormatException -> {
                        println("The transparency color input is invalid.")
                        exitProcess(1)
                    }
                }
            }

            readWaterMarkTransparency()
            createWaterMark()
            exitProcess(0)
        }
    }

    readWaterMarkTransparency()
    createWaterMark() // Alpha is no
}

fun sanityCheck(fileName: String, kind: String) {
    try {
        val image = ImageIO.read(File(fileName))

        when {
            image.colorModel.numColorComponents != 3 -> {
                println("The number of $kind color components isn't 3.")
                exitProcess(1)
            }
            image.colorModel.pixelSize !in 24..32 -> {
                println("The $kind isn't 24 or 32-bit.")
                exitProcess(1)
            }
        }
    } catch (e: IIOException) {
        println("The file $fileName doesn't exist.")
        exitProcess(1)
    }
}

fun readWaterMarkTransparency() {

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
}

fun createWaterMark() {

    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readln()

    val validFormat = outPutFileName.contains(".jpg") || outPutFileName.contains(".png")

    if (!validFormat) {
        // Terminate on invalid format
        println("The output file extension isn't \"jpg\" or \"png\".")
        exitProcess(1)
    }

    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    val outPutFileHandle = File(outPutFileName)
    outPutFileHandle.createNewFile()

    if (useAlpha == "yes"){
        // Consider alpha values during watermarking
        var outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB) // with alpha

        for (y in 0 until image.height){
            for (x in 0 until image.width) {
                val i = Color(image.getRGB(x, y))
                val w = Color(waterMark.getRGB(x, y), true)
                var color = Color(255, 255, 255)

                when(w.alpha) {
                    0 -> color = i //output pixel should be image pixel
                    255 -> {
                        color = Color(
                            (weight * w.red + (100 - weight) * i.red) / 100,
                            (weight * w.green + (100 - weight) * i.green) / 100,
                            (weight * w.blue + (100 - weight) * i.blue) / 100
                        )
                    }
                }
                outputImage.setRGB(x, y, color.rgb)
            }
        }

        ImageIO.write(outputImage, "png", outPutFileHandle)
        println("The watermarked image $outPutFileName has been created.")
        exitProcess(0)
    }

    // Do non alpha calculations if user chose to not use Alpha component
    val outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB) // No alpha

    for (y in 0 until image.height){
        for (x in 0 until image.width) {
            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(x, y))
            var color = Color(255,255,255)
            if (w.red == transparencyRed && w.green == transparencyGreen && w.blue == transparencyBlue) {
                color = i
            } else {
                color = Color(
                    (weight * w.red + (100 - weight) * i.red) / 100,
                    (weight * w.green + (100 - weight) * i.green) / 100,
                    (weight * w.blue + (100 - weight) * i.blue) / 100
                )
            }
            outputImage.setRGB(x, y, color.rgb)
        }
    }

    ImageIO.write(outputImage, "png", outPutFileHandle)
    println("The watermarked image $outPutFileName has been created.")
}