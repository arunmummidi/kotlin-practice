/*Let's create software that will be useful for a bank!

Consider the Compound interest formula:

finalAmount=startingAmount⋅(1+yearlyPercent100)yearsfinalAmount=startingAmount⋅(1+100yearlyPercent​)years

This equation shows how much money a customer should earn for a given starting amount, a yearly percent and a number of years for holding a deposit in the bank. The common arguments are $1000 for the starting amount, 5% for yearly percent, and 10 years for a deposit.

One of the banks asks you to create a program for bank employees. This program will help to calculate the final amount for non-default parameters. The employee will input one parameter that they want to change: the name of the parameter (amount, percent, or years) and a new value of this parameter. Try to use named parameters to solve this problem!

You need to create a program that reads the name and the value of a new parameter, calculates the compound interest, and prints the final amount for this new parameter.

Input: the first line of the input contains the parameter that a customer changed: amount for the starting amount, percent for yearly percent, or years for the number of years. The next line contains a single integer number: the value of the parameter.

Output: the integer part of the sum.*/

import kotlin.math.pow

fun main() {
    compoundInterest(readln(), readln().toInt())
}

fun compoundInterest(
    userArgument: String,
    userArgumentValue:Int
) {
    var amount: Int = 1000
    var percent: Int = 5
    var years: Int = 10
    when (userArgument) {
        "amount" -> amount = userArgumentValue
        "percent" -> percent = userArgumentValue
        "years" -> years = userArgumentValue
    }
    val finalAmount = amount * Math.pow(1.0 + percent.toDouble() / 100.0, years.toDouble())
    println(finalAmount.toInt())
}