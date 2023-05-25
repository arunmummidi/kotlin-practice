/*
Add the member name: String to the class Vehicle and the constructor that takes one argument name: String.

Inside the class Vehicle create a new inner class Body. The new inner class should have a member color: String, a constructor that takes one argument color: String, and a function fun printColor(), which prints the name of the Vehicle and the color of the Body in the following format: The <name> vehicle has a <color> body.
*/
// Inner classes
class Vehicle(name: String = "") {
    val name: String = name
    // create constructor

    // create inner class Body
    inner class Body(color: String) {
        val color: String = color

        fun printColor() {
            println("The ${this@Vehicle.name} vehicle has a $color body.")
        }
    }
}

fun main() {
    val dixi = Vehicle("Dixi")
    dixi.Body("red").printColor()
}