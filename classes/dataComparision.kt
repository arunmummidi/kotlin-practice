/*
Write a program that reads six values (name, age, balance, name, age, balance) and uses all of them as fields of a data class, that is, Client.

Change this given data class in order to check two different clients disregarding their balances. It means that two clients are equal if they have the same name and age. Print the result as true or false.
*/

/*
John
19
0
John
19
22
*/

data class Client(val name: String, val age: Int, val balance: Int)

fun main() {
    //implement your code here
    val user1Name = readln()
    val user1Age = readln().toInt()
    val user1Balance = readln().toInt()
    val user2Name = readln()
    val user2Age = readln().toInt()
    val user2Balance = readln().toInt()
    val user1 = Client(user1Name, user1Age, user1Balance)
    val user2 = Client(user2Name, user2Age, user2Balance)
    println(user1.name == user2.name && user1.age == user2.age)
}