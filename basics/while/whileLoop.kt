fun main() {
// Loops
    var studentCount = readln().toInt()
    var A = 0
    var B = 0
    var C = 0
    var D = 0

    while(studentCount != 0) {
        var grade = readln().toInt()
        when (grade){
            5 -> A++
            4 -> B++
            3 -> C++
            2 -> D++
        }
        studentCount--
    }
    println("$D $C $B $A")
}
