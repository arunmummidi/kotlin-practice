fun main() {
//    Variable type conversion
    print("Please enter the galactic empire ships count:")
    val galacticShips: String? = readLine()
    print("Please enter the rebellion ships count:")
    val rebellionShips: String? = readLine()
    val magnitude = galacticShips?.toInt()?.div(rebellionShips?.toInt()!!)
    print("The Galactic ship magnitude is:")
    print(magnitude)

}