//Create a program that checks whether a car exceeds a speed limit.
//
//Write a function checkSpeed() that will take two arguments: speed and limit. By default the limit is 60 kilometers per hour.
//
//The speed contains the actual speed of the car. The limit contains the limit on the road. If there is no special restriction, you must apply the default limit.
//
//Output Exceeds the limit by N kilometers per hour where N is kilometers per hour above the limit. If everything's OK, output Within the limit.

fun checkSpeed(speed: Int, limit: Int = 60) {
    if (speed < limit) {
        println("Within the limit")
    } else println("Exceeds the limit by ${speed - limit} kilometers per hour")
}