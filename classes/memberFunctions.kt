fun main() {
    var store = VinylStore("Red")
    store.printVinyl()
}

class VinylStore(var vinyl: String) {
    fun printVinyl() {
        println(vinyl)
    }
}

class Box(var height: Double, var width: Double, var length: Double) {

    // write the getVolume method here
    fun getVolume(): Double {
        return height * width * length
    }
}



/*Given a class named Application with one string property name.

Add a member function named run that takes three strings and returns nothing. The function should output the name of the application and then all the arguments, each one in a new line.*/

fun main() {
    var app = Application("Hello world")
    app.run("arun", "is", "great")
}
class Application(val name: String) {
    fun run(str1: String, str2: String, str3: String) {
        println("$name\n$str1\n$str2\n$str3")
    }
}
