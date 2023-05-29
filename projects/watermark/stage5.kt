/* Description

In the final stage, we will lift the image requirements of sharing the dimensions! But for simplicity, limit the watermark image — it must be smaller or equal to the original image. The error message for different dimensions of two images isn't valid anymore, so a new one will be used, in case a dimension of the watermark image is larger than the original image dimension.

In this stage, we will put a single watermark logo or several as a grid. Take a look at some examples:
If users want to place a single watermark, ask for its position. The position is denoted by two integer numbers (X for horizontal and Y for vertical) that are the number of pixels from the top-left corner. (0,0) is the initial position (see the Figure below). X is a value from 0 to <Image width - Watermark width>, and Y is a value from 0 to <Image height - Watermark height>:

Watermark Position Calculation

The watermark pixels should be blended with the image pixels as in the previous stage. All other image pixels remain the same.

You may want to position the watermark as a grid. In this case, the watermark should be initially set at the top-left corner. Then repeat the watermark towards the right corner and the bottom until all space is covered.
Objectives

    Compare the dimensions of the two images. If the watermark image has at least one dimension larger than the dimension of the original image, print The watermark's dimensions are larger. and terminate the program (Example 8);
    Before asking users for the output image filename, ask for the position method with Choose the position method (single, grid):, and read the user input. If this input isn't single or grid, print The position method input is invalid. and terminate the program (Example 5);
    If the user input is single, then print Input the watermark position ([x 0-DiffX] [y 0-DiffY]):, where DiffX is an integer equal to the subtraction <Image width - Watermark width>, and DiffY is an integer equal to the subtraction<Image height - Watermark height> (Examples 1 and 2). The position is two integers in the given range, separated by one space;
    If the position input is correct, create the output image as described in the Description section (Examples 1 and 2);
    If the position input isn't valid, print The position input is invalid. and terminate the program (Example 6);
    If the input integers are out of range, print The position input is out of range. and terminate the program (Example 7);
    If the user input is grid, create the output image as described in the Description section (Examples 3 and 4).

Examples

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1: a single watermark (image 500x700, watermark 150x150)

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to set a transparency color?
> yes
Input a transparency color ([Red] [Green] [Blue]):
> 255 255 255
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> single
Input the watermark position ([x 0-350] [y 0-550]):
> 100 100
Input the output image filename (jpg or png extension):
> out.jpg
The watermarked image out.jpg has been created.

Example 2: a single watermark with the alpha channel (image 500x700, watermark 150x150)

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to use the watermark's Alpha channel?
> yes
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> single
Input the watermark position ([x 0-350] [y 0-550]):
> 100 100
Input the output image filename (jpg or png extension):
> out.jpg
The watermarked image out.jpg has been created.

Example 3: grid watermarks

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to set a transparency color?
> yes
Input a transparency color ([Red] [Green] [Blue]):
> 255 255 255
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> grid
Input the output image filename (jpg or png extension):
> out.png
The watermarked image out.png has been created.

Example 4: grid watermarks with the alpha channel

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to use the watermark's Alpha channel?
> yes
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> grid
Input the output image filename (jpg or png extension):
> out.png
The watermarked image out.png has been created.

Example 5: invalid position method

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to set a transparency color?
> yes
Input a transparency color ([Red] [Green] [Blue]):
> 255 255 255
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> pos
The position method input is invalid.

Example 6: invalid position input (image 500x700, watermark 150x150)

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to set a transparency color?
> yes
Input a transparency color ([Red] [Green] [Blue]):
> 255 255 255
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> single
Input the watermark position ([x 0-350] [y 0-550]):
> top right
The position input is invalid.

Example 7: position is out of range (image 500x700, watermark 150x150)

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
Do you want to set a transparency color?
> yes
Input a transparency color ([Red] [Green] [Blue]):
> 255 255 255
Input the watermark transparency percentage (Integer 0-100):
> 20
Choose the position method (single, grid):
> single
Input the watermark position ([x 0-350] [y 0-550]):
> 500 0
The position input is out of range.

Example 8: dimensions are larger

Input the image filename:
> image.jpg
Input the watermark image filename:
> watermark.jpg
The watermark's dimensions are larger. */

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
var outPutFileName = ""
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
        useAlpha == "yes" && positionMethod == "single" -> {
            drawAlphaSingle()
            exitProcess(0)
        }
        useAlpha == "yes" && positionMethod == "grid" -> {
            // Grid
            drawAlphaGrid()
            exitProcess(0)
        }
        waterMarkHasAlpha == "no" && specifyBackgroundColor == "yes" && positionMethod == "grid" -> {
            // Grid
            drawNoAlphaBackgroundGrid()
            exitProcess(0)
        }
        useAlpha == "no" && positionMethod == "single" && specifyBackgroundColor == "yes" -> {
            drawNoAlphaSingleBackground()
            exitProcess(0)
        }
        else -> println("Do something else")
    }
}

fun readOutPutFile(): File {
    println("Input the output image filename (jpg or png extension):")
    outPutFileName = readln()

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
    println("The watermarked image $outPutFileName has been created.")
}

fun drawAlphaSingle() {
    /*Load buffered images of image file
    and Watermark file.*/
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    /*Read and validate output file name.
    Get its file descriptor if valid.*/
    val outPutFileHandle = readOutPutFile()
    outPutFileHandle.createNewFile()

    for (x in waterMarkCoordinateX until waterMark.width + waterMarkCoordinateX){
        for (y in waterMarkCoordinateY until waterMark.height + waterMarkCoordinateY) {
            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(x - waterMarkCoordinateX, y - waterMarkCoordinateY), true)

            when(w.alpha) {
                0 -> color = i // If watermark pixel's alpha is 0 (transparent), output pixel should be image pixel
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

fun drawNoAlphaBackgroundGrid() {

    /*Load buffered images of image file
    and Watermark file.*/
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    /*Read and validate output file name.
    Get its file descriptor if valid.*/
    val outPutFileHandle = readOutPutFile()
    outPutFileHandle.createNewFile()

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            val offsetX = x % waterMark.width
            val offsetY = y % waterMark.height

            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(offsetX, offsetY))

            if (w.red == transparencyRed && w.green == transparencyGreen && w.blue == transparencyBlue) {
                color = i
            } else {
                color = Color(
                    (weight * w.red + (100 - weight) * i.red) / 100,
                    (weight * w.green + (100 - weight) * i.green) / 100,
                    (weight * w.blue + (100 - weight) * i.blue) / 100
                )
            }
            image.setRGB(x, y, color.rgb)
        }
    }
    ImageIO.write(image, "png", outPutFileHandle)
    println("The watermarked image $outPutFileName has been created.")
}

fun drawAlphaGrid() {

    /*Load buffered images of image file
and Watermark file.*/
    val image = ImageIO.read(File(imageFile))
    val waterMark = ImageIO.read(File(waterMarkFile))

    /*Read and validate output file name.
    Get its file descriptor if valid.*/
    val outPutFileHandle = readOutPutFile()
    outPutFileHandle.createNewFile()

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

            image.setRGB(x, y, color.rgb)
        }
    }
    ImageIO.write(image, "png", outPutFileHandle)
    println("The watermarked image $outPutFileName has been created.")
}
