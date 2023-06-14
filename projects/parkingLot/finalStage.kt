/*Now it's time to add some query commands.

The command reg_by_color prints all registration numbers of cars of a particular color, taking color as a parameter. The color may be written in uppercase or lowercase letters. For example, reg_by_color BLACK. The answer should contain registration numbers separated by commas. The order should be the same as in the status command. If there are no cars of this color, the output should be like this: No cars with color BLACK were found..

The command spot_by_color is similar to the previous one, but it prints the parking space numbers of all the cars of a particular color.

The command spot_by_reg returns you the number of the spot where a car is located based on its registration number, for example, spot_by_reg KA-01. This command will also return an error message if your car was not found: No cars with registration number KA-01 were found. For convenience, let's suppose that all car registration numbers are unique.*/

/*
reg_by_color green
KA-01-HH-9999, KA-01-HH-3672
No cars with color BLACK were found.

spot_by_color Green
No cars with color GREEN were found.
3, 4

spot_by_reg ABC
No cars with registration number ABC were found.
2
*/


var parkingLot = mutableListOf<MutableList<String>>()
var parkingLotSize = 0
var parkingLotOccupied: Boolean = false
var inputString = ""
var parsedStrings: List<String> = listOf<String>()
var command: String = ""
var registrationNumber:String = ""
var color: String = ""
var spot: String = ""

fun main() {
    while(command.lowercase() != "exit") {
        readUserInput()
    }
}

// Function declarations
fun readUserInput() {
    inputString = readLine()!!
    parsedStrings = inputString.split(" ")
    command = parsedStrings[0]
    when (command.lowercase()) {
        "exit" -> println()

        "status" -> {
            if (parkingLotSize > 0) {
                parkingLotStatus()
            } else println("Sorry, a parking lot has not been created.")
        }

        "create" -> {
            parkingLotSize = parsedStrings[1].toInt()
            createParkingLot()
        }

        "park" -> {
            if(parkingLotSize == 0) {
                println("Sorry, a parking lot has not been created.")
                return
            }
            registrationNumber = parsedStrings[1]
            color = parsedStrings[2].uppercase()
            park()
        }

        "leave" -> {
            if(parkingLotSize == 0) {
                println("Sorry, a parking lot has not been created.")
                return
            }
            spot = parsedStrings[1]
            leave()
        }
        "reg_by_color" -> {
            if(parkingLotSize == 0) {
                println("Sorry, a parking lot has not been created.")
                return
            }
            color = parsedStrings[1].uppercase()
            status()
        }
        "spot_by_color" -> {
            if(parkingLotSize == 0) {
                println("Sorry, a parking lot has not been created.")
                return
            }
            color = parsedStrings[1].uppercase()
            statusSpot()
        }
        "spot_by_reg" -> {
            if(parkingLotSize == 0) {
                println("Sorry, a parking lot has not been created.")
                return
            }
            registrationNumber = parsedStrings[1]
            statusRegistration()
        }
    }
}

fun createParkingLot() {
    parkingLot = mutableListOf()
    parkingLotOccupied = false
    parkingLot.add(
        mutableListOf("RESERVED"))
    for (i in 1..parkingLotSize) {
        parkingLot.add(mutableListOf(i.toString(), "FREE"))
    }
    println("Created a parking lot with $parkingLotSize spots.")
}

fun parkingLotStatus() {
    loop@
    for (i in 1..parkingLotSize) {
        if (parkingLot[i].contains("OCCUPIED")) {
            parkingLotOccupied = true
            println(parkingLot[i][0] + " " + parkingLot[i][2] + " " + parkingLot[i][3])
        }
    }
    if (parkingLotOccupied == false) println("Parking lot is empty.")
}

fun park() {

    loop@
    for (i in 1..parkingLotSize) {
        if (parkingLot[i].contains("FREE")) {
            parkingLot[i] = mutableListOf(i.toString(), "OCCUPIED", registrationNumber, color)
            println("$color car parked in spot $i.")
            break
        } else {
            if (i < parkingLotSize) loop@continue
            println("Sorry, the parking lot is full.")
        }
    }
}

fun leave() {
    if (parkingLot[spot.toInt()][1] == "FREE") {
        println("There is no car in spot $spot.")
    } else {
        parkingLot[spot.toInt()] = mutableListOf("FREE")
        println("Spot $spot is free.")
    }
}

fun status() {
    var outPutList = mutableListOf<String>()

    for (i in 1..parkingLotSize) {
        if (parkingLot[i].contains(color)) {
            outPutList.add(parkingLot[i][2])
        }
    }
    if (outPutList.size == 0) {
        println("No cars with color $color were found.")
    } else println(outPutList.joinToString(truncated = "["))
}

fun statusSpot() {
    var outPutList = mutableListOf<String>()
    loop@
    for (i in 1..parkingLotSize) {
        if (parkingLot[i].contains(color)) {
            outPutList.add(parkingLot[i][0])
        }
    }
    if (outPutList.size == 0) {
        println("No cars with color $color were found.")
    } else println(outPutList.joinToString(truncated = "["))
}

fun statusRegistration() {
    var outPutList = mutableListOf<String>()
    loop@
    for (i in 1..parkingLotSize) {
        if (parkingLot[i].contains(registrationNumber)) {
            outPutList.add(parkingLot[i][0])
        }
    }
    if (outPutList.size == 0) {
        println("No cars with registration number $registrationNumber were found.")
    } else println(outPutList.joinToString(truncated = "["))
}