/*
Rock-Paper-Scissors game
Imagine that you want to play the "Rock-Paper-Scissors" game and you need to write a function makeDecision() that returns "Rock", "Paper", or "Scissors" depending on a random number from 1 to 3.

Write that function

import kotlin.random.Random */

fun makeDecision(): String {
    val inventoryList = listOf("Rock", "Paper", "Scissors")
    return inventoryList[Random.nextInt(3)]

}

