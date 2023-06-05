import kotlin.system.exitProcess

class CoffeeMachine{
    var action = ""

    enum class MachineContext{
        INVENTORY,
        BUY,
        FILL,
        TAKE
    }

    fun readAction(action: String) {
        val context = MachineContext.INVENTORY
        when(action) {
            "remaining" -> Inventory().showInventory()
            "buy" ->
        }
    }

    class Coffee() {
        var water = 0
        var milk = 0
        var coffeeBeans = 0
        val disposableCups = 1
        var cost = 0

        fun buyCoffee(){
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")

        }
    }

    class Inventory{
        var water = 400
        var milk = 540
        var coffee = 120
        var disposableCups = 9
        var money = 550

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
    }

    /*fun fillInventory() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        disposableCups += readln().toInt()
    }*/

/*    fun dispenseCash() {
        println("I gave you \$$money")
        money = 0
    }*/

}


fun main() {
    val machineInstance = CoffeeMachine()
    println("Write action (buy, fill, take, remaining, exit):")
    machineInstance.readAction(readln())

    val espresso = CoffeeMachine.Coffee()
    espresso.water = 250
    espresso.coffeeBeans = 16
    espresso.cost = 4

    val cappuccino = CoffeeMachine.Coffee()
    cappuccino.water = 200
    cappuccino.milk = 100
    cappuccino.coffeeBeans = 12
    cappuccino.cost = 6

    val latte = CoffeeMachine.Coffee()
    latte.water = 350
    latte.milk = 75
    latte.coffeeBeans = 20
    latte.cost = 7
}



/*
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

        }
        "take" -> {

        }
        "exit" -> exitProcess(0)
        "remaining" -> showInventory()
    }
}*/

