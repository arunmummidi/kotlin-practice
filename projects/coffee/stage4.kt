/*Let's simulate an actual coffee machine! What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups. Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement: first, it should sell coffee. It can make different types of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, however, in any case, you will need only one disposable cup for a drink. Second, the coffee machine must get replenished by a special worker. Third, another special worker should be able to take out money from the coffee machine.
Objectives

Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out. Note that the program is supposed to do one of the mentioned actions at a time. It should also calculate the amounts of remaining ingredients and how much money is left. Display the quantity of supplies before and after purchase.

First, your program reads one option from the standard input, which can be "buy", "fill", "take". If a user wants to buy some coffee, the input is "buy". If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be "fill". If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input "take".
If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
If the user writes "fill", the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
If the user writes "take" the program should give all the money that it earned from selling coffee.

At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user, as well as print the coffee machine's state after that. Try to use functions for implementing every action that the coffee machine can do.*/

var water = 400
var milk = 540
var coffee = 120
var disposableCups = 9
var money = 550
var flavour = ""

fun main() {
    showInventory()
    showMenu()
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
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
            when(readln().toInt()) {
                1 -> {
                    flavour = "espresso"
                    water -= 250
                    coffee -= 16
                    money += 4
                    disposableCups--
                }
                2 -> {
                    flavour = "latte"
                    water -= 350
                    milk -= 75
                    coffee -= 20
                    money += 7
                    disposableCups--
                }
                3 -> {
                    flavour = "cappuccino"
                    water -= 200
                    milk -= 100
                    coffee -= 12
                    money += 6
                    disposableCups--
                }
            }
            showInventory()
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

            showInventory()
        }
        "take" -> {
            println("I gave you \$$money")
            money = 0

            showInventory()
        }
    }
}
