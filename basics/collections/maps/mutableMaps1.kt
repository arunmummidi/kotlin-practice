/*Write a program that reads the names of students and their exam scores, adds them to MutableMap, and prints the result. In this MutableMap, names are keys, and scores are values. It is guaranteed that the keys are Strings and the values are of Int type.

Keys and values must be read on a new line each. Input is over when the program receives the word "stop" instead of the next key. If the same key is entered more than one time, MutableMap must keep the value that was entered first.

See the input and output examples:

Input: key: String, value: Int (on a new line), until the word "stop" is read.

Output: resulting MutableMap<String, Int>.

Sample Input 1:

Alice
88
John
92
Harry
60
stop
Sample Output 1:

{Alice=88, John=92, Harry=60}
Sample Input 2:

Alice
45
Alice
66
stop
Sample Output 2:

{Alice=45}*/

val scores = mutableMapOf<String, Int>()
fun main() {
    appendMap()
    println(scores)
}

fun appendMap() {
    var key = ""
    var value = 0
    key = readln()

    if(key != "stop"){
        if(!scores.containsKey(key)) {
            value = readln().toInt()
            scores.put(key, value)
            appendMap()
        }
    } else return
}
