//package cinema
val charList = mutableListOf(
    mutableListOf(' ', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
    mutableListOf('1', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('2', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('3', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('4', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('5', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('6', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('7', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('8', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
    mutableListOf('9', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')
)
var totalRows = 0
var seatsPerRow = 0
var firstHalfRows = 0
var secondHalfRows = 0
var totalSeats = 0
var totalIncome = 0
var purchasedTickets = 0
var currentIncome = 0
var rowNumber = 0
var seatNumber = 0
fun main() {
    println("Enter the number of rows:")
    totalRows = readln().toInt()
    println("Enter the number of seats in each row:")
    seatsPerRow = readln().toInt()
    firstHalfRows = totalRows / 2
    secondHalfRows = totalRows - firstHalfRows
    totalSeats = firstHalfRows * seatsPerRow + secondHalfRows * seatsPerRow
    if (totalSeats < 60) {
        totalIncome = totalSeats * 10
    } else {
        totalIncome = (firstHalfRows * seatsPerRow * 10) + (secondHalfRows * seatsPerRow * 8)
    }

    printMenu()
// End of Main()
}

// Functions
fun printMenu() {
    println()
    println(
        """
    1. Show the seats
    2. Buy a ticket
    3. Statistics
    0. Exit
    """.trimMargin()
    )
    val inputChoice = readln().toInt()
    when (inputChoice) {
        1 -> {
            showTheSeats()
            printMenu()
        }

        2 -> {
            buyTicket()
            printMenu()
        }

        3 -> {
            printStatistics()
            printMenu()
        }

        0 -> println()
    }
}

fun showTheSeats() {
    println()
    println("Cinema:")
    for (i in 0..totalRows) {
        for (j in 0..seatsPerRow) {
            print(charList[i][j] + " ")
        }
        println()
    }
}

fun buyTicket() {
    println()
    println("Enter a row number:")
    rowNumber = 0
    seatNumber = 0
    rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    seatNumber = readln().toInt()
    if (rowNumber > totalRows || seatNumber > seatsPerRow || rowNumber < 0 || seatNumber < 0) {
        println("Wrong input!")
        buyTicket()
    }
    if (charList[rowNumber][seatNumber] == 'B') {
        println("That ticket has already been purchased!")
        buyTicket()
    }

    if (totalSeats < 60 && rowNumber > 0) {
        println("Ticket price: $10")
        currentIncome = currentIncome + 10
    } else {
        if (rowNumber <= firstHalfRows && rowNumber > 0) {
            println("Ticket price: $10")
            currentIncome = currentIncome + 10
        } else {
            if (rowNumber > 0) {
                println("Ticket price: $8")
                currentIncome = currentIncome + 8
            }
        }
    }
    charList[rowNumber][seatNumber] = 'B'
    ++purchasedTickets

}

fun printStatistics() {
    val ticketsPercentage = purchasedTickets * 100 / (totalRows * seatsPerRow).toDouble()
    val formatPercentage = "%.2f".format(ticketsPercentage)
    println("Number of purchased tickets: $purchasedTickets")
    println("Percentage: $formatPercentage%")
    println("Current income: $$currentIncome")
    println("Total income: $$totalIncome")

}