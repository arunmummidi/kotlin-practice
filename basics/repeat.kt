// Repeat function                                                                                                                                

fun main() {
    print("How many numbers to count:\n> ")
    val count = readln().toInt()
    var sum = 0 
    
    repeat(count) {
        sum += readln().toInt()
    }   
    print(sum)



// 2
    repeat(4) {                                                                                                                                 
    val input = readln()
    val char = input[0]
    var code = char.code
    print(code.toChar())
    }

}
