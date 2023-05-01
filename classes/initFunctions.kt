// Write your class below
class Person(var name: String, var age: Int, var favoriteColor: String) {
    init {
        println("$name is $age years old and his favorite color is $favoriteColor")
    }
}


fun main() {
    // Create your instances below
    var me = Person("arun", 22, "pink")
    var myFriend =  Person("friend", 23, "blue")
}