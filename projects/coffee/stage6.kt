/*Let's redesign our program and write a class that represents a coffee machine. The class should have a method that takes a string as input. Every time the user inputs a string to the console, the program invokes this method with one argument: the line that the user inputs to the console. This system simulates pretty accurately how real-world electronic devices work. External components (like buttons on the coffee machine or tapping on the screen) generate events that pass into the single interface of the program.

The class should not use system input at all; it will only handle the input that comes to it via this method and its string argument.

The first problem that comes to mind: how to write that method in a way that it represents all that coffee machine can do? If the user inputs a single number, how can the method determine what that number is: a variant of coffee chosen by the user or the number of the disposable cups that a special worker added into the coffee machine?

The right solution to this problem is to store the current state of the machine. The coffee machine has several states it can be in. For example, the state could be "choosing an action" or "choosing a type of coffee". Every time the user inputs something and a program passes that line to the method, the program determines how to interpret this line using the information about the current state. After processing this line, the state of the coffee machine can be changed or can stay the same.

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

Objective

Your final task is to refactor the program. Make it so that you can communicate with the coffee machine through a single method.*/

import kotlin.system.exitProcess

class CoffeeMachine{
    var action = ""
    var water = 400
    var milk = 540
    var coffee = 120
    var disposableCups = 9
    var money = 550

    fun remaining() {
        println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $coffee g of coffee beans
        $disposableCups disposable cups
        ${'$'}$money of money
    """.trimIndent())
    }

    fun buy(): String {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when(readln()) {
            "1" -> {
                when {
                    water < 250 -> println("Sorry, not enough water!")
                    coffee < 16 -> println("Sorry, not enough coffee!")
                    disposableCups < 1 -> println("Sorry, not enough water!")
                    else -> {
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
                        water -= 200
                        milk -= 100
                        coffee -= 12
                        money += 6
                        disposableCups--
                    }
                }
            }
            "back" -> return "back"
        }
        return ""
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        disposableCups += readln().toInt()
    }

    fun take() {
        println("I gave you \$$money")
        money = 0
    }

    fun showMenu() {
        while (true) {
            println("Write action (buy, fill, take, remaining, exit):")

        }
    }
}


fun main() {
    val machineInstance = CoffeeMachine()

    while(true) {
        println("Write action (buy, fill, take, remaining, exit):")
        loop@
        when(readln()){
            "buy" -> {
                val choice = machineInstance.buy()
                if(choice == "back"){
                    loop@continue
                }
            }
            "fill" -> machineInstance.fill()
            "take" -> machineInstance.take()
            "remaining" -> machineInstance.remaining()
            "exit" -> break
        }
    }
}
