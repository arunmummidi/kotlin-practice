fun main() {
// Characters and unicode transformation
    val char = '\u0000'
    var count = 200
    for (i in 1..100) print(char + i)

    var test = '9'
    val unicode = test.code
    print(unicode)

    for (i in 1..4) {
        val string = readln()
        val char = string[0]
        println(char.isDigit())
//        if (char.code in 48..57) println(true)
//        else println(false)
    }

    repeat(4) {
        val input = readln()
        val char = input[0]
        var code = char.code
        code++
        print(code.toChar())
    }

    val char1 = readln().first().lowercase()
    val char2 = readln().first().lowercase()
    println(char1 == char2)
    println(readln().first().lowercase() == readln().first().lowercase())

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
}