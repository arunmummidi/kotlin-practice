/*In real life, parking lots vary in size. At this stage, we will get better at making art imitate life. To do this, we will make our program customizable by adding a create command that allows the user to specify the number of spots. For example, the command create 3 makes a parking lot with three spots. The number of spots should be positive. The program output should be the following: Created a parking lot with 3 spots.

Other commands like park or leave should return an error Sorry, a parking lot has not been created. until the user enters the create command. If the user calls create again, the previous parking state should be reset.

It is also important to keep track of which spaces are occupied by which cars. For this, add a status command that prints all occupied spots in ascending order. For each spot, it should print the spot number, the car’s plate registration number, and the color of the car, all separated by spaces like the example below. If there are no occupied spots, the program should print: Parking lot is empty.*/

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
            color = parsedStrings[2]
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