/*Write a program that declares an enum DaysOfTheWeek and prints the name of each enum's instance on a new line, starting from SUNDAY.*/

enum class DaysOfTheWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

fun main() {
    for (day in DaysOfTheWeek.values()) {
        println(day)
    }
}
