fun main() {
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
}