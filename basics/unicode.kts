// Characters and unicode transformation

fun main() {
    val char = '\u0000'
    var count = 200
    for (i in 1..100) print(char + i)
                                                                                                                                                
    var test = '9'
    val unicode = test.code
    print(unicode)

    println("--------------------------------------")
    

    for (i in 1..4) {
        val string = readln()
        val char = string[0]
        println(char.isDigit())
        if (char.code in 48..57) println(true)
        else println(false)
    }
}
