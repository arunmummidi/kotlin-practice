

 Null or not null
Problem of the day solved
Next problem in: 11h 32s

Write a function named nullOrNotNull, which takes an argument number of type Int? and returns -1 if number is null; otherwise, it returns number.
// write your function here

fun nullOrNotNull(number: Int?) = run { number ?: -1 }