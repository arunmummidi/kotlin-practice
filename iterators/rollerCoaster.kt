/*Roller coasters!
You decided to automate the process of controlling the access to a roller coaster. For this purpose, you wrote a function checkHeight(height: Int). If a person's height is less than 145cm or more than 210cm, they can't enter the roller coaster.

If a person can enter the roller coaster, checkHeight should print "You can go!" on a new line; otherwise, if their height doesn't fit, it prints "Sorry, not today".*/

fun checkHeight(iterator: Iterator<Int>) {
    iterator.forEach {
        if(it > 145 && it < 210) {
            println("You can go!")
        } else println("Sorry, not today")
    }
}

fun main() {
    val list = readln().split(" ").map(Integer::parseInt).toList()
    checkHeight(list.iterator())
}
