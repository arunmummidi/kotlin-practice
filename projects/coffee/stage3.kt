/* A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. And if you input a really big number, it's almost certain that a real coffee machine wouldn't have the supplies needed to make all that coffee for you.

In this stage, you need to improve the previous program. Now you will check amounts of water, milk, and coffee beans available in your coffee machine at the moment.
Objectives

Write a program that does the following:

    It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups a user needs.
    If the coffee machine has enough supplies to make the specified amount of coffee, the program should print "Yes, I can make that amount of coffee".
    If the coffee machine can make more than that, the program should output "Yes, I can make that amount of coffee (and even N more than that)", where N is the number of additional cups of coffee that the coffee machine can make.
    If the amount of given resources is not enough to make the specified amount of coffee, the program should output "No, I can make only N cups of coffee".

Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.
*/

package machine
var waterForCup = 200
var milkForCup = 50
var coffeeForCup = 15
var extraCups = 0
var possibleCups = 0

fun main() {

    readMachineContents()
}

fun readMachineContents() {
    println("Write how many ml of water the coffee machine has:")
    val waterContent = readln().toInt()

    println("Write how many ml of milk the coffee machine has:")
    val milkContent = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeContent = readln().toInt()

    println("Write how many cups of coffee you will need:")
    val requiredCups = readln().toInt()

    if(waterContent > waterForCup * requiredCups && milkContent > milkForCup * requiredCups && coffeeContent > coffeeForCup) {
        val extraWaterContent = waterContent - waterForCup * requiredCups
        val extraMilkContent = milkContent - milkForCup * requiredCups
        var extraCoffeeContent = coffeeContent - coffeeForCup * requiredCups
        var extraWaterCups = extraWaterContent / waterForCup
        var extraMilkCups = extraMilkContent / milkForCup
        var extraCoffeeCups = extraCoffeeContent / coffeeForCup

        if (extraWaterCups <= extraMilkCups && extraWaterCups <= extraCoffeeCups) {
            extraCups = extraWaterCups
        } else if( extraMilkCups <= extraCoffeeCups) {
            extraCups = extraMilkCups
        } else {
            extraCups = extraCoffeeCups
        }

        if(extraCups > 0) {
            println("Yes, I can make that amount of coffee (and even $extraCups more than that)")
        } else println("Yes, I can make that amount of coffee")
    } else {
        if (waterContent / waterForCup <= milkContent / milkForCup && waterContent / waterForCup <= coffeeContent / coffeeForCup) {
            possibleCups = waterContent / waterForCup
        } else if( milkContent / milkForCup <= coffeeContent / coffeeForCup) {
            possibleCups = milkContent / milkForCup
        } else {
            possibleCups = coffeeContent / coffeeForCup
        }

        println("No, I can make only $possibleCups cups of coffee")
    }
}
