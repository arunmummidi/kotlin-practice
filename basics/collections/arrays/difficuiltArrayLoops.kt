/*Check the numbers
Write a program that reads an array of integers and two numbers p and m. The program is to check that p and m never occur next to each other (in any order) in the array.

Input data format

The first line contains the size of an array, N.
The next N lines contain elements of the array.
The last line contains two integer numbers p and m., separated by the space character.

Output data format

The result is a single value, that is, "YES" if p and m never occur next to each other, otherwise, "NO".*/

fun main() {
    val size = readln().toInt()
    var integerArray = IntArray(size)

    for(index in 0 .. size -1) {
        integerArray[index] = readln().toInt()
    }

    val string = readln().split(' ')

    val indexOfP = integerArray.indexOf(string[0].toInt())
    val indexOfM = integerArray.indexOf(string[1].toInt())

    for(i in 0 until size) {
        if(i == size - 1){
            println("YES")
            return
        }
        if ( integerArray[i] == string[0].toInt() && integerArray[i + 1] == string[1].toInt()
            || integerArray[i] == string[1].toInt() && integerArray[i + 1] == string[0].toInt()) {
            println("NO")
            return
        }
    }
    println("NO")
}
