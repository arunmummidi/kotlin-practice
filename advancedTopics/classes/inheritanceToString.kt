/*The class Latte is inherited from the class Coffee. Override the toString() function so that it returns the same as for the parent class. Add the information about milk like in the template at the end: SUPER; milk=MILK, where MILK is the value of the parameter milk and SUPER is superclass realization.

Sample output:

SUPER; milk=almond*/

class Latte(val milk: String, cost: Int, volume: Int) : Coffee(cost, volume) {
    override fun toString(): String {
        return Coffee(cost, volume).toString() + "; milk=$milk"
    }
}

class Latte(val milk: String, cost: Int, volume: Int) : Coffee(cost, volume) {
    override fun toString(): String {
        return super.toString() + "; milk=$milk"
    }
}