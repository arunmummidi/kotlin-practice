/*
Frequency word book
You need to do a task related to natural language processing: count the occurrence of words in a text. You need to read a line of words and print a map where the key represents a word and the value represents its occurrences. The keys should come in the order they occur in the original line. Below, you can find an example of the output.
*/


fun main() {
    val list = readln().split(" ")

    val myMap = mutableMapOf<String, Int>()

    for (string in list) {
        if(myMap.containsKey(string)) {
            myMap[string] = myMap[string]!! + 1
        } else myMap[string] = 1
    }

    for(string in myMap.keys){
        println("$string ${myMap[string]}")
    }
}
