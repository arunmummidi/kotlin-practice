fun main() {
//Boolean operation
    val invitation = readLine().toBoolean() // read other value in the same way
    // write your code here
    val gift = readlnOrNull().toBoolean()
    print(invitation && gift)

    val x = readln().toBoolean() // read other values in the same way
    // write your code here
    val y = readln().toBoolean()
    val z = readln().toBoolean()
    println(!(x && y) || (z))

    val num = readln().toInt()
    println(((num.toString()).reversed()).toInt())
}