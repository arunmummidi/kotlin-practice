/*Just one action is not so interesting, is it? Let's improve the program so it can do multiple actions, one after another. It should repeatedly ask a user what they want to do. If the user types "buy", "fill" or "take", then the program should do exactly the same thing it did in the previous step. However, if the user wants to switch off the coffee machine, they should type "exit". The program should terminate on this command. Also, when the user types "remaining", the program should output all the resources that the coffee machine has. This means that you shouldn't show the remaining stock levels at the beginning/end of the program.

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

Objectives

Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given. Introduce two new options: "remaining" and "exit".

Do not forget that you can be out of resources for making coffee. If the coffee machine doesn't have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee and state what is missing.

And the last improvement to the program at this step — if the user types "buy" to buy a cup of coffee and then changes his mind, they should be able to type "back" to return into the main cycle.*/

import kotlin.system.exitProcess

var water = 400
var milk = 540
var coffee = 120
var disposableCups = 9
var money = 550
var flavour = ""

fun main() {
    while(true){
        showMenu()
    }
}

fun showInventory() {
    println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $coffee g of coffee beans
        $disposableCups disposable cups
        ${'$'}$money of money
    """.trimIndent())
}

fun showMenu() {
    println("Write action (buy, fill, take): ")
    when(readln()) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
            when(readln()) {
                "1" -> {
                    when {
                        water < 250 -> println("Sorry, not enough water!")
                        coffee < 16 -> println("Sorry, not enough coffee!")
                        disposableCups < 1 -> println("Sorry, not enough water!")
                        else -> {
                            flavour = "espresso"
                            water -= 250
                            coffee -= 16
                            money += 4
                            disposableCups--
                        }
                    }

                }
                "2" -> {
                    when {
                        water < 350 -> println("Sorry, not enough water!")
                        coffee < 20 -> println("Sorry, not enough coffee!")
                        milk < 75 -> println("Sorry, not enough milk!")
                        disposableCups < 1 -> println("Sorry, not enough water!")
                        else -> {
                            flavour = "latte"
                            water -= 350
                            milk -= 75
                            coffee -= 20
                            money += 7
                            disposableCups--
                        }
                    }
                }
                "3" -> {
                    when {
                        water < 200 -> println("Sorry, not enough water!")
                        coffee < 12 -> println("Sorry, not enough coffee!")
                        milk < 100 -> println("Sorry, not enough milk!")
                        disposableCups < 1 -> println("Sorry, not enough water!")
                        else -> {
                            flavour = "cappuccino"
                            water -= 200
                            milk -= 100
                            coffee -= 12
                            money += 6
                            disposableCups--
                        }
                    }

                }
                "back" -> showMenu()
            }
        }
        "fill" -> {
            println("Write how many ml of water you want to add:")
            water += readln().toInt()
            println("Write how many ml of milk you want to add:")
            milk += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffee += readln().toInt()
            println("Write how many disposable cups you want to add: ")
            disposableCups += readln().toInt()
        }
        "take" -> {
            println("I gave you \$$money")
            money = 0
        }
        "exit" -> exitProcess(0)
        "remaining" -> showInventory()
    }
}
