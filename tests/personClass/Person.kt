/*Imagine that you have a task to fix an implementation of a Person class to make it pass the following unit tests written according to business logic requirements:
The Person class has a constructor that accepts two arguments, a string name and an integer age, and should set the name and age fields of the object according to the criteria set out in the unit tests.*/

class Person(personName: String?, personAge: Int) {
    // Do not change this part
    companion object {
        const val DEFAULT_NAME = "Unknown"
        const val MAX_AGE = 130
        const val MIN_AGE = 0
    }

    // Fix this to make its code pass the unit tests

    var name = DEFAULT_NAME
    var age = 0

    init {
        if(personAge >= MIN_AGE) age = personAge + MIN_AGE

        if(personAge > MAX_AGE) age = MAX_AGE


        if(personName != null && personName.isNotEmpty()) {
            val isNameValid = personName.filter { it in 'A'..'Z' || it in 'a'..'z' }.length  == personName.length
            if(isNameValid)  name = personName
        }

        if (personName != null) {

        }
    }
}
