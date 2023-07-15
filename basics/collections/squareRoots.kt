//Square roots of expression with given inputs
fun main() {
    val scanner = Scanner(System.`in`)
    // Read a, b, c, d
    val varA: Double = scanner.nextInt().toDouble()
    val varB: Double = scanner.nextInt().toDouble()
    val varC: Double = scanner.nextInt().toDouble()
    val varD: Double = scanner.nextInt().toDouble()
    scanner.close()
    var varX: Double
    val rootList = mutableListOf<Int>() //Mutable Integer list to store square roots

    // Run through 0 to 1000 values to find square root
    for (i in 0..1000) {
        varX = i.toDouble()
        val expression = varA * (Math.pow(varX.toDouble(), 3.toDouble())) +
                varB * (Math.pow(varX.toDouble(), 2.toDouble())) +
                varC * varX + varD
        if (expression.toInt() == 0) rootList.add(varX.toInt())
    }   
    // Sort square roots in ascending order and print                                                                                               
    rootList.sort()
    for (i in 0..rootList.lastIndex) {
        println(rootList[i])
    }   
    val count = readln().toInt()
    val integerList = mutableListOf<Int>()
    repeat(count){
        integerList.add(readln().toInt())
    }   
    integerList.sort()
    println(integerList[0])
}
