package watermark

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
var diffX = 0
var diffY = 0
//val e = Exception()

fun main() {
    println("Input the image filename:")
    imageFile = readln()
    sanityCheck(imageFile, "image")

    println("Input the watermark image filename:")
    waterMarkFile = readln()
    sanityCheck(waterMarkFile, "watermark")

    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    diffX = image.width - waterMark.width
    diffY = image.height - waterMark.height

    if (waterMark.height > image.height || waterMark.width > image.width) {
        println("The watermark's dimensions are larger.")
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
        val useTransparency = readln().lowercase()
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
                transparencyRed = inputString[0].toInt()
                transparencyGreen = inputString[1].toInt()
                transparencyBlue = inputString[2].toInt()
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
    println("Choose the position method (single, grid):")
    when (readln()) {
        "single" -> {
            println("Input the watermark position ([x 0-$diffX] [y 0-$diffY]):")
            val waterMarkPositionString = readln().split(' ')
            try {
                val waterMarkPositionX = waterMarkPositionString[0].toInt()
                val waterMarkPositionY = waterMarkPositionString[1].toInt()
                if (waterMarkPositionX !in 0..diffX || waterMarkPositionY !in 0..diffY ) {
                    println("The position input is out of range.")
                    exitProcess(1)
                }
            } catch (e: Exception) {
                println("The position input is invalid.")
                exitProcess(1)
            }

        }
        "grid" -> {

        }
        else -> {
            println("The position method input is invalid.")
            exitProcess(1)
        }
    }

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
        val outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB) // with alpha

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
//TODO
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
