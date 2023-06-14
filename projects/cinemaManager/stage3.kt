fun main() {
// Cinema manager program. Cinema Tickets - Stage 3

    print("Enter the number of rows:\n> ")
    val totalRows= readln().toInt()
    print("Enter the number of seats in each row:\n> ")
    val seatsPerRow = readln().toInt()
    println()
    println("Cinema:")
    print("  ")
    for (i in 1..seatsPerRow){
        print(i)
        print(" ")
    }
    println()

    for (j in 1..totalRows) {
        print(j)
        print(" S".repeat(seatsPerRow))
        println()
    }
    println()
    print("Enter a row number:\n> ")
    val rowNumber = readln().toInt()
    print("Enter a seat number in that row:\n> ")
    val seatNumber = readln().toInt()
    println()
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

    println()
    print("Cinema:")
    for (i in 1..seatsPerRow){
        print(" ")
    }
    println()

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
    charList[rowNumber][seatNumber] = 'B'
    for (i in 0 .. totalRows){
        for (j in 0 .. seatsPerRow) {
            print(charList[i][j] + " ")
        }
        println()
    }
}