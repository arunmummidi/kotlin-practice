import kotlin.math.roundToInt

fun main () {
    val perimeterPolgon = perimeter(0.0, 0.0, 12.0, 0.0, 0.0, 5.0)
    println(perimeterPolgon)
}

fun perimeter(x1: Double = 0.00, y1: Double = 0.00, x2: Double = 0.00, y2: Double = 0.00, x3: Double = 0.00, y3: Double = 0.00, x4: Double, y4: Double): Double {
    val d1 = Math.hypot(x2 - x1, y2 - y1)
    val d2 = Math.hypot(x3 - x2, y3 - y2)
    val d3 = Math.hypot(x4 - x3, y4 - y3)
    val d4 = Math.hypot(x1 - x4, y1 - y4)

    val perimeterPolygon = d1 + d2 + d3 + d4
    return perimeterPolygon
}
