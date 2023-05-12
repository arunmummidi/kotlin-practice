/*Image properties
Description
Watermarking is a popular method to claim ownership of an image. It is the process of superimposing a logo or text on an image file. In this project, you will learn to apply watermarks of 24-bit or 32-bit color images with logos.
Before we start blending two images, you need to know how to get the image properties. Images can be accessed in a BufferedImage instance with the use of the ImageIO class. The image properties can be consequently obtained by using that particular instance.
If image is a BufferedImage instance, then the following properties can be acquired:
Image height with image.height in pixels;
Image width with image.width in pixels;
The number of image components (can be colors or the alpha channel) with image.colorModel.numComponents;
The number of image colors with image.colorModel.numColorComponents;
The number of bits per pixel with image.colorModel.pixelSize;
Image transparency setting with image.transparency.
The transparency property (image.transparency) can be either Transparency.OPAQUE, Transparency.BITMASK or Transparency.TRANSLUCENT (integers 1 to 3 respectively). Field descriptions can be found in Transparency; the correspondence is located between the field and the values at Constant Field Values under the java.awt.Transparency header.
For example, a 24-bit color image (that is, three 8-bit colors) has 3 components, 3 colors, and the OPAQUE transparency (a value of 1). A 32-bit color image (three 8-bit colors and an alpha channel) has 4 components, 3 colors, and the TRANSLUCENT transparency (a value of 3).
Objectives

Print the following message: Input the image filename:
Users must input a filename (and a path if needed) of an image file. If the file exists, then print the following information (Examples 1 and 2):
Image file: [Image filename]
Width: [Image width]
Height: [Image height]
Number of components: [# of components]
Number of color components: [# of color components]
Bits per pixel: [Pixels for each pixel]
Transparency: [Transparency field]

If the user inputs a path together with the filename, then print the path with the filename. (Example 2).
If the file doesn't exist, print the following message: The file [Image filename] doesn't exist.(Example 3).
If you need some image files to experiment with your code for stage 1, then you can download this zip file.
Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.
Example 1: properties of a 24-bit image file
Input the image filename:
> water.jpg
Image file: water.jpg
Width: 500
Height: 500
Number of components: 3
Number of color components: 3
Bits per pixel: 24
Transparency: OPAQUE

Example 2: properties of a 32-bit image file with an alpha channel
Input the image filename:
> test/winter.png
Image file: test/winter.png
Width: 800
Height: 500
Number of components: 4
Number of color components: 3
Bits per pixel: 32
Transparency: TRANSLUCENT

Example 3: the file doesn't exist
Input the image filename:
> new.jpg
The file new.jpg doesn't exist.*/

//package watermark

import java.awt.Transparency
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import java.awt.Transparency.*

fun main() {
    println("Input the image filename:")
    val fileName = readln()
    val seperator = File.separator
    val fileDescriptor = File(fileName)

    // If file exists and contains path, then print path. Else print error
    if (fileDescriptor.exists() && fileName.contains(seperator)) {
        println("Image file: $fileName")

        // Create a Buffered image instance to read file attributes
        val image = ImageIO.read(fileDescriptor)
        println("Width: ${image.width}")
        println("Height: ${image.height}")
        println("Number of components: ${image.colorModel.numComponents}")
        println("Number of color components: ${image.colorModel.numColorComponents}")
        println("Bits per pixel: ${image.colorModel.pixelSize}")
        when(image.transparency) {
            OPAQUE -> println("Transparency: OPAQUE")
            BITMASK -> println("Transparency: BITMASK")
            TRANSLUCENT -> println("Transparency: TRANSLUCENT")
        }
    } else {
        if (fileName.contains(seperator)) {
            var fileNameParsed = fileName.split(seperator)
            println("The file ${fileNameParsed[fileNameParsed.size -1]} doesn't exist.")
        } else println("The file ${fileName} doesn't exist.")
    }
}