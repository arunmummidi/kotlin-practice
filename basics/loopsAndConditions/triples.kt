/*Write a program that reads an array of integers and outputs the number of triples in the array.

A triple is three consecutive integers in ascending order — 3,4,5 is a triple, but 5,4,3 and 2,4,6 are not.

The first line contains the size of the array.
The rest of the lines contain elements of the array.

Output a single integer value that is the number of triples in the array.

In the example below, there are two triples: 4,5,6 and 5,6,7.*/

 fun main () {
     // Read integer array's size
     val integerArraySize = readln().toInt()

     // Read integer array elements
     var integerArray = IntArray(integerArraySize)
     for (index in 0 until integerArraySize) {
         integerArray[index] = readln().toInt()
     }

     var triplets = 0
     for (index in 0 until integerArraySize - 2) {
         if(integerArray[index + 1] == integerArray[index] + 1 && integerArray[index + 2] == integerArray[index] + 2 )
             ++triplets
     }

     println(triplets)
 }
