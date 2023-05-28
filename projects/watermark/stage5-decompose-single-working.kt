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
var specifyBackgroundColor = ""
var transparencyRed = 0
var transparencyGreen = 0
var transparencyBlue = 0
var diffX = 0
var diffY = 0
var waterMarkCoordinateX = 0
var waterMarkCoordinateY = 0
var color = Color(255, 255, 255)
var positionMethod = ""
var waterMarkHasAlpha = "no"
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

/*     If the watermark image's dimentions are
     larger than image's dimenstinos, throw error and stop*/
    if (waterMark.height > image.height || waterMark.width > image.width) {
        println("The watermark's dimensions are larger.")
        exitProcess(1)
    }

    diffX = image.width - waterMark.width
    diffY = image.height - waterMark.height

    readAlphaChannel() // Read if alpha channel exists for watermark. If exists, read if alpha channel to be used.
    readDesiredTransparency() // sets transparency variable "weight". Common step
    setPositionMethod() // Common step. Read position method single/grid

    invokeAppropriateWaterMark() // Alpha is no
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

fun readAlphaChannel(){
    // Read if the watermark image has alpha channel component
    val waterMark = ImageIO.read(File(waterMarkFile))
    if(waterMark.transparency == TRANSLUCENT) {
        // Watermark image has alpha channel if transparency is translucent
        waterMarkHasAlpha = "yes"
        println("Do you want to use the watermark's Alpha channel?")
        useAlpha = readln().lowercase()
    } else {
        // Watermark image does not have alpha channel
        /*     If alpha channel is not present, ask user
        if transparency color needs to be set*/
        readTransparencyColor()
    }
}

fun readTransparencyColor() {
    println("Do you want to set a transparency color?")
    specifyBackgroundColor = readln().lowercase()
    if(specifyBackgroundColor == "yes") {
        println("Input a transparency color ([Red] [Green] [Blue]):")
        val inputString = readln().split(' ')

//        Sanity check user input
        try {
            for(value in inputString) {
                if (value.toInt() !in 0..255 || inputString.size != 3) {
                    println("The transparency color input is invalid.")
                    exitProcess(1)
                }
            }
            // set transparency values
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
    }
}

fun readDesiredTransparency() {

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

fun setPositionMethod() {
    println("Choose the position method (single, grid):")
    positionMethod = readln()
    when (positionMethod) {
        "single" -> {
            println("Input the watermark position ([x 0-$diffX] [y 0-$diffY]):")
            val waterMarkCoordinates = readln().split(' ')
            try {
                waterMarkCoordinateX = waterMarkCoordinates[0].toInt()
                waterMarkCoordinateY = waterMarkCoordinates[1].toInt()
                if (waterMarkCoordinateX !in 0..diffX || waterMarkCoordinateY !in 0..diffY ) {
                    println("The position input is out of range.")
                    exitProcess(1)
                }
            } catch (e: Exception) {
                println("The position input is invalid.")
                exitProcess(1)
            }
        }
        "grid" -> {
            /*Position method variable is already set to grid. Don't perform calculations here.*/
        }
        else -> {
            println("The position method input is invalid.")
            exitProcess(1)
        }
    }
}

fun invokeAppropriateWaterMark() {





    when {
        waterMarkHasAlpha == "yes" && positionMethod == "single" -> {
            drawWatermark()
            exitProcess(0)
        }
        waterMarkHasAlpha == "yes" && positionMethod == "grid" -> {
            // Grid
            drawWatermarkGrid()
            exitProcess(0)
        }
        waterMarkHasAlpha == "no" && positionMethod == "single" && specifyBackgroundColor == "yes" -> {
            drawNoAlphaSingleBackground()
            exitProcess(0)
        }
        else -> println("Do something else")
    }
}

fun readOutPutFile(): File {
    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readln()

    val validFormat = outPutFileName.contains(".jpg") || outPutFileName.contains(".png")
    if (!validFormat) {
        // Terminate on invalid format
        println("The output file extension isn't \"jpg\" or \"png\".")
        exitProcess(1)
    }
    return File(outPutFileName) // Return output file descriptor
}

fun drawNoAlphaSingleBackground() {
    /*Load buffered images of image file
    and Watermark file.*/
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    /*Read and validate output file name.
    Get its file descriptor if valid.*/
    val outPutFileHandle = readOutPutFile()
    outPutFileHandle.createNewFile()
    val outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB) // No alpha

    for (y in 0 until waterMark.height){
        for (x in 0 until waterMark.width) {
            val i = Color(image.getRGB(x + waterMarkCoordinateX, y + waterMarkCoordinateY))
            val w = Color(waterMark.getRGB(x, y))
//            var color = Color(255,255,255)
            if (w.red == transparencyRed && w.green == transparencyGreen && w.blue == transparencyBlue) {
                color = i
            } else {
                color = Color(
                    (weight * w.red + (100 - weight) * i.red) / 100,
                    (weight * w.green + (100 - weight) * i.green) / 100,
                    (weight * w.blue + (100 - weight) * i.blue) / 100
                )
            }
            image.setRGB(x + waterMarkCoordinateX, y + waterMarkCoordinateY, color.rgb)
        }
    }

    ImageIO.write(image, "png", outPutFileHandle)
    println("The watermarked image ${outPutFileHandle.absolutePath} has been created.")
}




fun drawWatermark() {
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readln()

    val outPutFileHandle = File(outPutFileName)
    outPutFileHandle.createNewFile()

    for (x in waterMarkCoordinateX until waterMark.width){
        for (y in waterMarkCoordinateY until waterMark.height) {
            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(x - waterMarkCoordinateX, y - waterMarkCoordinateY), true)

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
            image.setRGB(x, y, color.rgb)
        }
    }
    ImageIO.write(image, "png", outPutFileHandle)
    println("The watermarked image $outPutFileName has been created.")
}

fun drawWatermarkGrid() {
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readlnOrNull() ?: ""

    val outPutFileHandle = File(outPutFileName)
    outPutFileHandle.createNewFile()

    val outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB)

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            val offsetX = x % waterMark.width
            val offsetY = y % waterMark.height

            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(offsetX, offsetY), true)

            val alpha = w.alpha

            if (alpha == 0) {
                color = i
            } else if (alpha == 255) {
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

fun drawWatermarkGridNoAlpha() {
    setPositionMethod()
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    println("Input the output image filename (jpg or png extension):")
    val outPutFileName = readlnOrNull() ?: ""

    val outPutFileHandle = File(outPutFileName)
    outPutFileHandle.createNewFile()

    val outputImage = BufferedImage(image.width, image.height, TYPE_INT_ARGB)

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            val offsetX = x % waterMark.width
            val offsetY = y % waterMark.height

            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(offsetX, offsetY), true)

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


