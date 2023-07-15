fun sum(a: Int, b: Int) : Int {
    return a + b
}
fun getLastDigit(integer: Int): Int {
    if (integer > 0){
        integer % 10
    } else -integer % 10
    return integer
}
