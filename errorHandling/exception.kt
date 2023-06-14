fun main() {

    val e = Exception()

    try {
        2 / 0
    } catch (e: NullPointerException) {
        println("Null point exception received")
    } catch (e: ArithmeticException) {
        println("ArithmeticException recieved")
    } catch (e: Exception) {
        println("General exception received")
    }
}