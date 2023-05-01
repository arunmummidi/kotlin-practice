
// infix functions
infix fun String.arun_fun(string1: String): Boolean {
    return this == string1
}

fun main() {
//    // Basic printing
//    print(message = "Hello world")
//    // Read only immutable variables called values
//    val arun: String = "Male"

//    // Basic variable declaration and assignment
//    val counter = 100
//    print(counter)
//    print(arun)

////If statement
//    if (true) {
//        print(message = "You are correct")
//    } else {
//        print(message = "You are wrong!")
//    }

////When statement
//    val mercury = "Mercury"
//    when (mercury) {
//        "mercury" -> print(message = "Universe is intact")
//        "Mercury" -> print(message = "Universe is still intact")
//        else -> print(message = "Universe may be in danger")
//    }
//
//    var age = 40
//    var hasAccess: Boolean = true
//    when {
//        age < 18 && hasAccess -> println("False positive")
//        age > 21 && !hasAccess -> println("False negative")
//        else -> println("All working as expected")
//    }
//    val maxSurfaceTempInK = 700
//    when(maxSurfaceTempInK) {
//        700 -> println("This is Mercury's maximum surface temperature") // 1
//        0, 1, 2 -> println("It's as cold as it gets") // 2
//        in 300..699 -> println("This temperature is also possible on Mercury") // 3
//        !in 0..300 -> println("This is pretty hot") // 4
//        is Int -> println("Given variable is of type Int") // 6
//        else -> { // 7
//            // You can also use blocks of code on the right hand side, like here
//            println("Default case")
//        }
//    }

//    // For loops
//    val planets= arrayOf("earth", "venus", "neptune") //string arrays
//    for (i in 1 .. 5) println("hello")
//    for (i in 1 until 5) println("wow")
//    for (i in planets) println("$i")

////infix functions
//    val total = sum(1,3)
//    println(total)
//    val str1 = "Hello"
//    val str2 = "Hello"
//    val result = str1 arun_fun str2
//    println(result)


////Collections
//    val immutablelist = listOf("arun", "ramu")
//    println(immutablelist[0])
//
//    val mutablelist = mutableListOf("goa", "Khatmandu")
//    println(mutablelist[0])
//    mutablelist.add("Ranchi")
//    println(mutablelist)
//
//    val immutableset = setOf("earth", "moon", "mercury", "mercury") //duplicates are ignored
//    println(immutableset)
//
//    val mutableset = mutableSetOf("pen", "pencil")
//    mutableset.add("slate pencil")
//    println(mutableset)
//
//    val immutablemap = mapOf("apple" to "Fruit", "Rose" to "Flower")
//    println(immutablemap)

////printing and strings
//    println("\u001B[32mWE\u001B[0m \u001B[34mNEED\u001B[0m\n\n\u001B[32mTO\u001B[0m \u001B[34mLEARN\u001B[0m \u001B[32mKOTLIN\u001B[0m\n\n\u001B[34mAS\u001B[0m \u001B[32mQUICKLY\u001B[0m \u001B[34mAS POSSIBLE\u001B[0m")
//
//    for (i in 1..7){
//        println("#")
//    }

//// Cinema project
//    println("Cinema:")
//    print("  ")
//    for (i in 1..8){
//        print(i)
//        print(" ")
//    }
//    println()
//
//    for (j in 1..7) {
//        print(j)
//        print(" S".repeat(8))
//        println()
//    }

//Variable type conversion
//    print("Please enter the galactic empire ships count:")
//    val galacticShips: String? = readLine()
//    print("Please enter the rebellion ships count:")
//    val rebellionShips: String? = readLine()
//    val magnitude = galacticShips?.toInt()?.div(rebellionShips?.toInt()!!)
//    print("The Galactic ship magnitude is:")
//    print(magnitude)

// Standard input using scanner
//    val scanner = Scanner(System.`in`)
//    val num1 = scanner.nextInt()
//    val num2 = scanner.nextInt()
//    scanner.close()
//    println(num1)
//    println(num2)

//    val scanner = Scanner(System.`in`)
//    val line1 = scanner.nextLine()
//    val line2 = scanner.nextLine()
//    val num1 = scanner.nextInt()
//    val num2 = scanner.nextInt()
//    scanner.close()
//    println(line1)
//    println(line2)
//    println(num1)
//    println(num2)


//using readln() to read input
//    var (a, b) = readln().split(' ')
//    println(a)
//    println(b)
//    print(readln().toDouble())


//    val bit = 8.0
//    val short = 16.0
//    val int = 32.0
//    val long = 64.0
//
//    val exp = 2.0
//    println((exp.pow(bit)-1).toInt())
//    println((exp.pow(short)-1).toInt())
//    println((exp.pow(int)-1).toInt())
//    println((exp.pow(long)-1).toLong())

//// Printing max value of a datatype
//    val byte: Byte = Byte.MAX_VALUE
//    val short: Short = Short.MAX_VALUE
//    val int: Int = Int.MAX_VALUE
//    val long: Long = Long.MAX_VALUE
//    print("$byte\n$short\n$int\n$long")

//// Strings
//    println("\nEat sleep Code repeat".repeat(7))
//    print("""
//        Hello world....
//        Meowy
//    """.trimIndent())
//
//    print("""
//        {
//            "firstName": "John",
//            "lastName": "Smith",
//            "age": 35,
//            "phoneNumbers": [
//                {
//                    "type": "mobile",
//                    "number": "123 567-7890"
//                }
//            ]
//        }""".trimIndent())

// Process expressions in print
//    val scanner = Scanner(System.`in`)
//    val input = scanner.next()
//    scanner.close()
//    val length = input.length
//    print("${input.length} repetitions of the word $input: ${input.repeat(length)}")

//Boolean operation
//    val invitation = readLine().toBoolean() // read other value in the same way
//    // write your code here
//    val gift = readLine().toBoolean()
//    print(invitation && gift)

// Boolean operations
//    val x = readln().toBoolean() // read other values in the same way
//    // write your code here
//    val y = readln().toBoolean()
//    val z = readln().toBoolean()
//    println(!(x && y) || (z))

//    val num = readln().toInt()
//    println(((num.toString()).reversed()).toInt())


//Cinema project profit calculation
//    print("Enter the number of rows:\n> ")
//    val totalrows = readln().toInt()
//    print("Enter the number of seats in each row:\n> ")
//    val seatsperrow = readln().toInt()
//    val firsthalfrows = totalrows / 2
//    val secondhalfrows = totalrows - firsthalfrows
//    val totalseats = firsthalfrows * seatsperrow + secondhalfrows * seatsperrow
//    if (totalseats < 60) {
//        println("Total income:\n$${totalseats * 10} ")
//    } else {
//        println("Total income:\n$${firsthalfrows * seatsperrow * 10 + secondhalfrows * seatsperrow * 8}")
//    }

// Repeat function
//    print("How many numbers to count:\n> ")
//    val count = readln().toInt()
//    var sum = 0
//
//    repeat(count) {
//        sum += readln().toInt()
//    }
//    print(sum)

// Loops
//    var studentCount = readln().toInt()
//    var A = 0
//    var B = 0
//    var C = 0
//    var D = 0
//
//    while(studentCount != 0) {
//        var grade = readln().toInt()
//        when (grade){
//            5 -> A++
//            4 -> B++
//            3 -> C++
//            2 -> D++
//        }
//        studentCount--
//    }
//    println("$D $C $B $A")

// Logical operators and conditionals
//    val scanner = Scanner(System.`in`)
//    var count = scanner.nextInt()
//    var highestNumber =0
//    while (count != 0) {
//        var value = scanner.nextInt()
//        var reminder = value % 4
//        if (reminder == 0 && value > highestNumber) highestNumber = value
//        count--
//    }
//    println(highestNumber)

// Characters and unicode transformation
//    val char = '\u0000'
//    var count = 200
//    for (i in 1..100) print(char + i)
//
//    var test = '9'
//    val unicode = test.code
//    print(unicode)

//    for (i in 1..4) {
//        val string = readln()
//        val char = string[0]
//        println(char.isDigit())
////        if (char.code in 48..57) println(true)
////        else println(false)
//    }

//    repeat(4) {
//        val input = readln()
//        val char = input[0]
//        var code = char.code
//        code++
//        print(code.toChar())
//    }

//    val char1 = readln().first().lowercase()
//    val char2 = readln().first().lowercase()
//    println(char1 == char2)
//    println(readln().first().lowercase() == readln().first().lowercase())

//    Character to decimal to unicode concept
//    val integer = readln().toInt()
//    val character = readln().first()
//    val decimal = character.code.toString(10) //character to unicode and then to decimal
//    println(decimal.toInt() == integer)

//Character unicode operations
//    val char1 = readln().first().code
//    val char2 = readln().first().code
//    val char3 = readln().first().code
//    println(char2 == char1 + 1 && char3 == char2 +1)

// Ranges
//    println(readln().toInt() !in 1..10)

//Lists
//    var numbers = mutableListOf<Int>(12, 17, 8, 101, 33)

//    val N = readln().toInt() // Read number of lines
//    val integerArray = List(N) {readln().toInt()}
//    val index = integerArray.size - 1
//    var resultArray = mutableListOf<Int>() // Create an array to hold the output of calculation
//    for (i in 0..8) {
//
//        if (integerArray[i] <= integerArray[i+1]) {
//            resultArray += integerArray[i]
//        }
//    }
//    println(resultArray)

//    var N = readln().toInt()
//    var index = N - 1
//    var inputList = List(N) { readln().toInt() }
//    var count = 0
//    var tempCount = 0

//    var inputList = mutableListOf<Int>(1, 2 ,1, 1, 4 ,5)

// For loop and ranges big probelm
//    val index = readln().toInt() - 1
//    val inputList = List(index + 1) { readln().toInt() }
//    var tempCount = 0
//    var count = 0
//
//    for (i in 0..index) {
//        if (i == index) {
//            if (tempCount != 0) {
//                if (inputList[i] >= inputList[i - 1]) {
//                    ++count
//                    println(count)
//                    break
//                }
//            } else {
//                println(count + 1)
//                break
//            }
//        }
//        if (inputList[i] <= inputList[i + 1]) {
//            ++tempCount
//            if (tempCount >= count) count = tempCount
//        } else tempCount = 0
//    }
// Square roots of expression with given inputs
//    val scanner = Scanner(System.`in`)
//    // Read a, b, c, d
//    val varA: Double = scanner.nextInt().toDouble()
//    val varB: Double = scanner.nextInt().toDouble()
//    val varC: Double = scanner.nextInt().toDouble()
//    val varD: Double = scanner.nextInt().toDouble()
//    scanner.close()
//    var varX: Double
//    val rootList = mutableListOf<Int>() //Mutable Integer list to store square roots
//
//    // Run through 0 to 1000 values to find square root
//    for (i in 0..1000) {
//        varX = i.toDouble()
//        val expression = varA * (Math.pow(varX.toDouble(), 3.toDouble())) +
//                varB * (Math.pow(varX.toDouble(), 2.toDouble())) +
//                varC * varX + varD
//        if (expression.toInt() == 0) rootList.add(varX.toInt())
//    }
//    // Sort square roots in ascending order and print
//    rootList.sort()
//    for (i in 0..rootList.lastIndex) {
//        println(rootList[i])
//    }
//    val count = readln().toInt()
//    val integerList = mutableListOf<Int>()
//    repeat(count){
//        integerList.add(readln().toInt())
//    }
//    integerList.sort()
//    println(integerList[0])

// FizzBuzz
//    val lowestNumber = readln().toInt()
//    val highestNumber = readln().toInt()
//    for (i in lowestNumber .. highestNumber) {
//        if (i % 3 == 0 && i % 5 == 0) {
//            println("FizzBuzz")
//        } else {
//            if (i %3 == 0) {
//                println("Fizz")
//            } else {
//                if (i % 5 == 0) {
//                    println("Buzz")
//                } else println(i)
//            }
//        }
//    }

// String concatination
//    val firstList = readLine()!!.split(' ').map { it }.toMutableList()
//    val secondList = readLine()!!.split(' ').map { it }.toMutableList()
//    // do not touch the lines above
//    // write your code here
//    println(firstList.joinToString() + secondList.joinToString())

// Two dimensional String List manipulations
//    val inputList: MutableList<MutableList<String>> = mutableListOf()
//    val n = readLine()!!.toInt()
//    for (i in 0 until n) {
//        val strings = readLine()!!.split(' ').toMutableList()
//        inputList.add(strings)
//    }
//    // write your code here
//    val finalString: MutableList<MutableList<String>> = mutableListOf()
//    finalString.add(inputList.last())
//    finalString.add(inputList.first())
//    println(finalString)

// Three dimensional String Lists manipulation
//    val inputList: MutableList<MutableList<String>> = mutableListOf()
//    val n = readLine()!!.toInt()
//    for (i in 0 until n) {
//        val stringsList = readLine()!!.split(' ').toMutableList()
//        inputList.add(stringsList)
//    }
//    println(inputList[2].joinToString(separator = ", "))

//    Multi dimentional arrays 3x3x3
//    val intList: MutableList<MutableList<MutableList<Int>>> = mutableListOf(
//        mutableListOf(
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0)
//        ),
//        mutableListOf(
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0)
//        ),
//        mutableListOf(
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0),
//            mutableListOf(0, 0, 0)
//        )
//    )
//    println(intList)

    //    Cinema manager program. Cinema Tickets - Stage 3

//    print("Enter the number of rows:\n> ")
//    val totalRows= readln().toInt()
//    print("Enter the number of seats in each row:\n> ")
//    val seatsPerRow = readln().toInt()
//    println()
//    println("Cinema:")
//    print("  ")
//    for (i in 1..seatsPerRow){
//        print(i)
//        print(" ")
//    }
//    println()
//
//    for (j in 1..totalRows) {
//        print(j)
//        print(" S".repeat(seatsPerRow))
//        println()
//    }
//    println()
//    print("Enter a row number:\n> ")
//    val rowNumber = readln().toInt()
//    print("Enter a seat number in that row:\n> ")
//    val seatNumber = readln().toInt()
//    println()
//    val firstHalfRows = totalRows / 2
//    val secondHalfRows = totalRows - firstHalfRows
//    val totalSeats = firstHalfRows * seatsPerRow + secondHalfRows * seatsPerRow
//    if (totalSeats < 60) {
//        println("Ticket price: $10")
//    } else {
//        if (rowNumber <= firstHalfRows) {
//            println("Ticket price: $10")
//        } else println("Ticket price: $8")
//    }
//
//    println()
//    print("Cinema:")
//    for (i in 1..seatsPerRow){
//        print(" ")
//    }
//    println()
//
//    val charList = mutableListOf(
//        mutableListOf(' ', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
//        mutableListOf('1', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('2', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('3', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('4', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('5', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('6', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('7', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('8', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
//        mutableListOf('9', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')
//    )
//    charList[rowNumber][seatNumber] = 'B'
//    for (i in 0 .. totalRows){
//        for (j in 0 .. seatsPerRow) {
//            print(charList[i][j] + " ")
//        }
//        println()
//    }
//    val a = readLine()!!.toInt()

//    val index = readLine()!!.toInt()
//    if (index < 0 && check integer) throw Exception("There isn't such an element in the given string, please fix the index!")
//    val wordTemp = readLine()!!
//    val word: String
//    val size = wordTemp.length
//    if (index < size) {
//        word = wordTemp
//        println(word[index])
//    } else throw Exception("There isn't such an element in the given string, please fix the index!")
fun sum(a: Int, b: Int) : Int {
    return a + b
}
fun getLastDigit(integer: Int): Int {
    if (integer > 0){
        integer % 10
    } else -integer % 10
    return integer
}
