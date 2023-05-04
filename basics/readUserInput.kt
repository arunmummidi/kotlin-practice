import java.util.Scanner
fun main() {
// Standard input using scanner
    val scanner = Scanner(System.`in`)
    val num1 = scanner.nextInt()
    val num2 = scanner.nextInt()
    scanner.close()
    println(num1)
    println(num2)

    val scanner1 = Scanner(System.`in`)
    val line1 = scanner1.nextLine()
    val line2 = scanner1.nextLine()
    val num3 = scanner1.nextInt()
    val num4 = scanner1.nextInt()
    scanner1.close()
    println(line1)
    println(line2)
    println(num1)
    println(num2)

//using readln() to read input
    var (a, b) = readln().split(' ')
    println(a)
    println(b)
    print(readln().toDouble())
}

