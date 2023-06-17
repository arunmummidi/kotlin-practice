/*Standard input with Java Scanner
Topic repetition
Four numbers
Write a program that reads four integer numbers from one line and prints them each on a new line. Input numbers should be separated by one or more spaces.

[HINT]Use nextInt() to read numbers ignoring extra spaces.[/HINT]

HINT by
avatar
 Hubert Michalec
If you want to use split method, you may need this snippet with regex expression: "\\s+".toRegex()
Was this hint helpful?
Sample Input 1:

101    102 103  104
Sample Output 1:

101
102
103
104*/
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
//    val input = scanner.nextLine().split(' ').map { it.toInt() }.toIntArray()
    val inputString = scanner.nextLine().replace("\\s+".toRegex(), " ").split(' ')
    scanner.close()
    for (i in inputString.indices) {
        println(inputString[i])
    }
}
