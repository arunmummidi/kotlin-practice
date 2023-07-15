import kotlin.random.Random

fun main() {
    generatePredictablePassword(44)
}

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    println(Random.nextInt(65, 127).toChar())
    //for (index in 0..10) {
    //    randomPassword[index] = Random.nextInt(33, 127).toChar()
    //}
	return randomPassword
}
