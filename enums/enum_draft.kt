enum class DangerLevel(myLevel: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() {
        HIGH.getLevel()
        MEDIUM.getLevel()
        LOW.getLevel()
    }
}

fun main() {
    val high = DangerLevel.HIGH
    val medium = DangerLevel.MEDIUM

    println(high.getLevel() > medium.getLevel()) // true
}
