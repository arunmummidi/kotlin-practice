import kotlin.math.pow

fun f(x: Double): Double {
    var y: Double = 0.0
    if (x <= 0) y = f1(x)
    if(x > 0 && x < 1) y = f2(x)
    if(x >= 1) y = f3(x)
    return y
}

// implement your functions here
fun f1 (x: Double): Double {
    return x.pow(2) + 1
}

fun f2 (x: Double): Double {
    return 1 / x.pow(2)
}

fun f3 (x: Double): Double {
    return x.pow(2) - 1
}
