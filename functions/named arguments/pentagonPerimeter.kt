/*Change and implement the perimeter() function to calculate the perimeter of a polygon with 3 or 4 vertices, represented by X and Y coordinates. Vertices are passed sequentially.

Example of polygons with three and four vertices

You can use the Math.hypot(..., ...)function to calculate the length of the segment using the Pythagorean theorem. Math.hypot(x,y) returns .

Tip: Don't forget that a default value of an argument can be another argument.
Hint:
set x4 = x1 and y4 = y1 in the parameters, and return the sum of operations Math.hypot(x1 - x2, y1 - y2), Math.hypot(x2 - x3, y2 - y3) and so on, and in the last Math .hypot(x first - x last, y first - y last). It was the only one that worked for me. Hope this helps.
Was this hint helpful?*/

import kotlin.math.hypot

fun main() {
    perimeter(0.0, 0.0, 12.0, 0.0, 0.0, 5.0)
}

fun perimeter(
    x1: Double = 0.0,
    y1: Double = 0.0,
    x2: Double = 0.0,
    y2: Double = 0.0,
    x3: Double = 0.0,
    y3: Double = 0.0,
    x4: Double = x1,
    y4: Double = y1
): Double {
    val d1 = hypot(x2 - x1, y2 - y1)
    val d2 = hypot(x3 - x2, y3 - y2)
    val d3 = hypot(x4 - x3, y4 - y3)
    val d4 = hypot(x1 - x4, y1 - y4)

    val perimeterPolygon = d1 + d2 + d3 + d4
    return perimeterPolygon
}