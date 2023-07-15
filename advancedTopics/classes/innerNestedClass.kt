//Create a function fun printHorsePower() that prints the name of the Vehicle and the horsePower of the Engine in the following format: The <name> vehicle has <horsePower> horsepower.

// Nested Inner class
class Vehicle(val name: String) {
    inner class Engine(val horsePower: Int) {
        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The $name vehicle has ${this@Engine.horsePower} horsepower.")
        }
    }
}

fun main() {
    val bmw = Vehicle("BMW")
    bmw.Engine(20).printHorsePower()
}