/*
Roll the dice
Let's play a game. We'll write a program that simulates rolling a six-sided dice. Players roll it over and over again and it produces numbers from 1 to 6 in an almost unpredictable way.

Your task is to write a function that returns a random integer value in the interval [1, 6] each time it's called.*/

import kotlin.random.Random

fun main() {
    println(throwD6())
}

fun throwD6(): Int {
    // write your code here
    return Random.nextInt(1, 7)
}
