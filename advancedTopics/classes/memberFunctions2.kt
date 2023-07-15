/*
Given a class named Car containing three properties: the Int property year, the String property make, and the Int property speed.

Add the following member functions to the class:

    accelerate adds 5 to the speed property each time it's called;
decelerate subtracts 5 from the speed property each time it's called. The speed cannot be less than zero, so if you get a negative speed, just make it equal to 0.
*/


class Car(val make: String, val year: Int) {

    var speed: Int = 0

    // write the methods here
    fun accelerate() {
        speed += 5
    }

    fun decelerate() {
        if(speed > 0)
        speed -= 5
    }
}
