/*Your little brother wants to learn by heart different currencies, so you want to create a game for him. The game is to read two countries and print true if those countries have the same currency and false if the currencies are different in these countries, or there is no information about at least one of them.

To create this game, you need to write a special dictionary with the following countries and currencies:*/

import kotlin.system.exitProcess

enum class Currencies(val currencyName: String){
    Germany("Euro"),
    Mali("CFA Franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA Franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar"),
    NULL("")
}

fun main() {
    val countries = readln().split(' ')
    val currencies = Currencies.values()

    var country1Index = -1
    var country2Index = -1

    for(index in currencies.indices) {
        when (currencies[index].toString()) {
            countries[0] -> country1Index = index
            countries[1] -> country2Index = index
        }
    }

    if (country1Index == -1 || country2Index == -1){
        println("false")
        exitProcess(0)
    }

    if (currencies[country1Index].currencyName == currencies[country2Index].currencyName) {
        println("true")
    }else println("false")
}
