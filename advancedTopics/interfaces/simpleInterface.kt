fun main() {
    val bmw = Car()
    bmw.start()
    bmw.stop()
}

interface Vehicle {
    fun start()
    fun stop()
}

class Car: Vehicle {
    override fun start() {
        println("Starting the Car")
    }
    override fun stop() {
        println("Stopping the Car")
    }
}
