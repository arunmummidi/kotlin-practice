/*
Write a class named ArithmeticOperations containing two properties: an Int property x and an Int property y.

Add the following member functions to the class:

    addition – adds x to y;
subtraction – subtracts y from x;
multiplication – multiplies x by y;
division – divides x by y.

Each function returns the result of the operation.*/

fun main() {
    var operation = ArithmeticOperations(1, 2)
}

class ArithmeticOperations(var x: Int, var y: Int) {
    fun addition(): Int {
        return x + y
    }

    fun subtraction(): Int {
        return x - y
    }

    fun multiplication(): Int {
        return x * y
    }

    fun division(): Int {
        if (y != 0) {
            return x / y
        } else throw Exception("Division by Zero")
    }
}