package cinema

fun main() {
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

    println("Enter the number of rows:")
    val totalRows= readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()
    printMenu(charList, totalRows, seatsPerRow)

// End of Main()
}

// Functions

fun printMenu(charList: MutableList<MutableList<Char>>, totalRows: Int, seatsPerRow: Int,) {
    println()
    println("""
    1. Show the seats
    2. Buy a ticket
    0. Exit
    """.trimMargin())
//    print("> ")
    when (readln().toInt()) {
        1 -> {
            showTheSeats(charList, totalRows, seatsPerRow)
            printMenu(charList, totalRows, seatsPerRow)
        }
        2 -> {
            buyTicket(charList, totalRows, seatsPerRow)
            printMenu(charList, totalRows, seatsPerRow)
        }
        0 -> println()
//        0 -> exitProcess(0) // Exit
//        0 -> System.exit(0)

//        else -> printMenu(charList, totalRows, seatsPerRow)
    }
}

fun showTheSeats(charList: MutableList<MutableList<Char>>, totalRows: Int, seatsPerRow: Int) {
    println()
    println("Cinema:")
    for (i in 0..totalRows) {
        for (j in 0..seatsPerRow) {
            print(charList[i][j] + " ")
        }
        println()
        //    charList[rowNumber][seatNumber] = 'B'
    }
}

fun buyTicket(charList: MutableList<MutableList<Char>>, totalRows: Int, seatsPerRow: Int) {
    println()
    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()
    val firstHalfRows = totalRows / 2
    val secondHalfRows = totalRows - firstHalfRows
    val totalSeats = firstHalfRows * seatsPerRow + secondHalfRows * seatsPerRow
    if (totalSeats < 60) {
        println("Ticket price: $10")
    } else {
        if (rowNumber <= firstHalfRows) {
            println("Ticket price: $10")
        } else println("Ticket price: $8")
    }
    /*
    Book ticket. ie update
    the seat element in the list
     */
    charList[rowNumber][seatNumber] = 'B'
}