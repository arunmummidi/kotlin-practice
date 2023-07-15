//Writing a string counter
//
//Write a function that takes a list of objects and returns the number of strings in the list. If the list item is not a string, it must be skipped. The function must use the is or !is operators to check the type of list items.

fun countStrings(list: List<Any>): Int {
    // make your code here
    var count = 0
    for (i in 0 until list.size) {
        if(list[i] is String) count++
    }
    return count
}