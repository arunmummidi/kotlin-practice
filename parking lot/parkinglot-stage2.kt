var parkingLot = mutableListOf<MutableList<String>>()
var inputString = ""
var parsedStrings: List<String> = listOf<String>()
var command: String = ""
var registrationNumber:String = ""
var color: String = ""
var spot: String = ""

fun main() {
    parkingLot.add(
        mutableListOf("RESERVED"))
    for (i in 1..20) {
        parkingLot.add(mutableListOf(i.toString(), "FREE"))
    }
    while(command.lowercase() != "exit") {
        readUserInput()
    }

    //here
}

// Function declarations
fun readUserInput() {
    inputString = readLine()!!
    parsedStrings = inputString.split(" ")
    command = parsedStrings[0]
    when (command.lowercase()) {
        "exit" -> println()
        "park" -> {
            registrationNumber = parsedStrings[1]
            color = parsedStrings[2]
            park()
        }

        "leave" -> {
            spot = parsedStrings[1]
            leave()
        }
    }
}

fun park() {
    loop@
    for (i in 1..20) {
        if (parkingLot[i].contains("FREE")) {
            parkingLot[i] = mutableListOf(i.toString(), "OCCUPIED", registrationNumber, color)
            println("$color car parked in spot $i.")
            break
        } else {
            if (i < 20) loop@continue
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