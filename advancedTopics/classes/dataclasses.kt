/*toString() modification

There is a program that reads three numbers (height, length, width) and prints all of them as fields of a data class, that is, Box. There is also an internal field which is size.

Modify the data class in order to print only the height, width, and size values.*/

data class Box(val height: Int, val length: Int, val width: Int) {
    var size: Int = height + length + width
    override fun toString() : String {
        return "Box(height=$height, width=$width, size=$size)"
    }
}