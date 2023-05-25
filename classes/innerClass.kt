/*Here is an outer class Vehicle with an inner class Engine. Please, start the engine.

Tip: Don't forget to instantiate the classes to get access to the start function.*/

class Vehicle {
    inner class Engine {
        fun start() {
            println("RRRrrrrrrr....")
        }
    }
}
// do not touch the class above

fun main() {
    // start your vehicle, put your code here
    Vehicle().Engine().start()
}