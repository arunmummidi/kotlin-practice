/*Imagine that you have a wish list. It's very long and you want all the listed items; however, you can't buy the items with the price greater than limit.

Write a function makeMyWishList that returns a map with all the elements with the price lower than or equal to limit.*/

fun makeMyWishList(wishList: Map<String, Int>, limit: Int): MutableMap<String, Int> {
    val updatedList = mutableMapOf<String, Int>()

    for( key in wishList.keys) {
        if(wishList[key]!! <= limit) {
            wishList[key]?.let { updatedList.put(key, it) }
        }
    }

    return updatedList
}
