// Class definition - short hand
class Student(val name: String, val className: String, val gpa: Double, val semester: String) {
    init { // Init function block executes after the object is created
        println("Hello $name, welcome to Nalanda University. Your admission into $semester is complete")
    }

    // Member function
    fun calculateGrade (){
        when(gpa) {
            in 1.0..4.0 -> println("You have passed with Average grade")
            in 5.0..8.0 -> println("You have passed with Good grade")
            in 9.0..10.0 -> println("You have passed with distinction grade")
        }
    }
}

fun main() {
    var student = Student("Arun", "CSC", 2.11, "Fourth") //Primary constructor shorthand (Initializing the values while creating object)
    println("Hello!" + student.name)
    student.calculateGrade() // Calling Member function
}