/*Description

In this stage, we will start blending images. To keep things simple, we will be dealing with transparency in this stage. Two images should have the same dimensions. Also, all images in this project must be either 24-bit or 32-bit.

Generally, the procedure of blending two identically sized images is very straightforward. Each pixel in an output image has a value that is a linear combination of the pixel color values in input images. Pixel color values of input images are weighted as per users' wishes.

The procedure is as follows:

Get the watermark weight percentage weight from users. Here, we will use only integer operations, so we require this percentage to be an integer number between 0 to 100.
For each pixel position (x, y) in the input images, read the Color from the watermarked image and the Color from the watermark image. For example:

val i = Color(image.getRGB(x, y))
val w = Color(watermark.getRGB(x, y))

where image and watermark are BufferedImage instances for the two input images.

Calculate the Color for the corresponding pixel of the output image:

val color = Color(
    (weight * w.red + (100 - weight) * i.red) / 100,
    (weight * w.green + (100 - weight) * i.green) / 100,
    (weight * w.blue + (100 - weight) * i.blue) / 100
)

Set it at the output BufferedImage instance at position (x, y) as output.setRGB(x, y, color.rgb), where output is a BufferedImage instance.

Since we don't use transparency in this stage, the result images aren't truly watermarked. They are nothing but two blended images.
Images blended with 20% watermark transparency percentage
Images blended with 20% watermark transparency percentage
Images blended with 20% watermark transparency percentage
Images blended with 20% watermark transparency percentage

As you can see, the resulting image is affected by the watermark logo background. However, we will work on it in the next stages by introducing transparency in two different ways to achieve true watermarking.

In this project, it's a good idea to use the exitProcess() function to exit our program at any time. Refer to the Kotlin documentation for more details.
Objectives

Ask for an image filename with the following message: Input the image filename:. Users should input a filename:

If the file doesn't exist, print The file [filename] doesn't exist. and terminate the program (Example 2);
If the image doesn't have 3 color components, print The number of image color components isn't 3. and terminate the program (Example 3);
If the image isn't 24 or 32-bit, then print The image isn't 24 or 32-bit. and terminate the program (Example 4).

Ask for a watermark image filename with the message Input the watermark image filename:. Users are expected to input the watermark filename:

If the watermark file doesn't exist, print The file [watermark filename] doesn't exist. and terminate the program (Example 5);
If the watermark image doesn't have 3 color components, print The number of watermark color components isn't 3. and terminate the program (Example 6);
If the watermark image doesn't use a 24-bit or a 32-bit color scheme, then print The watermark isn't 24 or 32-bit. and terminate the program (Example 7);
Compare the dimensions of two images; if they are different, print The image and watermark dimensions are different. and terminate the program (Example 8).

Ask for the watermark color weight percentage with the message Input the watermark transparency percentage (Integer 0-100):

If the input isn't an integer number, print The transparency percentage isn't an integer number. and terminate the program (Example 9);
If the input is an integer number but outside the 0-100 range, print The transparency percentage is out of range. and terminate the program (Example 10).

Ask for the output image filename with the message Input the output image filename (jpg or png extension):

If a provided filename doesn't have .jpg or .png extension, print The output file extension isn't "jpg" or "png". and terminate the program (Example 11).

Create the output image by blending the image and the watermark, save it as the provided output image filename, and then print The watermarked image [output filename] has been created. (Example 1). The blending should be done as described in the Description section. Output images must be saved as BufferedImage.TYPE_INT_RGB — the 24-bit color scheme without the alpha channel.

If you need some image files to experiment with your code for stage 2, then you can download this zip file.*/

/*Input the image filename:
> myimage.jpg
Input the watermark image filename:
> logo.jpg
Input the watermark transparency percentage (Integer 0-100):
> 20
Input the output image filename (jpg or png extension):
> out.gif
The output file extension isn't "jpg" or "png".*/

package watermark

import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.*
import java.io.File
import javax.imageio.ImageIO
import javax.imageio.IIOException
import kotlin.system.exitProcess

var weight: Int = 0
var imageFile = ""
var waterMarkFile = ""
var useAlpha = "no"

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
        createWaterMark()
        exitProcess(0)
    }

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
    readWaterMarkTransparency()

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
    val outputImage = BufferedImage(image.width, image.height, TYPE_INT_RGB) // No alpha

    for (y in 0 until image.height){
        for (x in 0 until image.width) {
            val i = Color(image.getRGB(x, y))
            val w = Color(waterMark.getRGB(x, y))
            val color = Color(
                (weight * w.red + (100 - weight) * i.red) / 100,
                (weight * w.green + (100 - weight) * i.green) / 100,
                (weight * w.blue + (100 - weight) * i.blue) / 100
            )

            outputImage.setRGB(x, y, color.rgb)
        }
    }
    
    ImageIO.write(outputImage, "png", outPutFileHandle)
    println("The watermarked image $outPutFileName has been created.")
}