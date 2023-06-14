 Leap year

Is a year a leap year?

Just a reminder: leap years are the years, whose number is either divisible by 4, but not divisible by 100, or divisible by 400 (for example, the year 2000 is a leap year, but the year 2100 is not).

The program should work for the years 1900 ≤ n ≤ 3000.

Output "Leap" (case-sensitive) if the year is a leap, otherwise print "Regular".

fun main() {
    // write your code here
    val inputNumber = readln().toInt()
    
    if (inputNumber % 4 != 0 || inputNumber % 400 == 100) {
        println("Regular")
    }  else {
        if (inputNumber % 4 == 0) println("Leap")
    }
}
