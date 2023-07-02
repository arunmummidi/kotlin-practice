// Characters and unicode transformation

fun main() {
    val char = '\u0000'
    var count = 200
    for (i in 1..100) print(char + i)
                                                                                                                                                
    var test = '9'
    val unicode = test.code
    print(unicode)

//    Character to decimal to unicode concept                                                                                                     
    val integer = readln().toInt()
    val character = readln().first()
    val decimal = character.code.toString(10) //character to unicode and then to decimal
    println(decimal.toInt() == integer)

//Character unicode operations
    val char1 = readln().first().code
    val char2 = readln().first().code
    val char3 = readln().first().code
    println(char2 == char1 + 1 && char3 == char2 +1)
    

    for (i in 1..4) {
        val string = readln()
        val char = string[0]
        println(char.isDigit())
        if (char.code in 48..57) println(true)
        else println(false)
    }
}
