/*In the store, all products are stored in a Map<String, Int>, which holds name - price pairs.
The customer comes with a shopping list and wants to know what the total price of products on the list will be. Keep in mind that some products may not be available in the store.

You are given Map<String, Int> (product name and price) and MutableList of String (shopping list) as the function parameters. Return the total price of the items the customer needs to buy.

Sample Input 1:

{Cola to 500}, {Apple to 1500}, {Banana to 300}
Cola Apple

Sample Output 1:

2000*/

fun main(){
    val priceList = mapOf("Cola" to 500, "Apple" to 1500, "Banana" to 300)
    val shoppingList = mutableListOf<String>("Banana", "Apple")

    bill(priceList, shoppingList)
}

fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var totalEstimate = 0

    for (item in shoppingList) {
        if(priceList.containsKey(item)) {
            totalEstimate += priceList.get(item)?.toInt() ?: 0
        }
    }

    return totalEstimate
}
