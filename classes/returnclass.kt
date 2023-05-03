//Implement the makeReddit() function that returns a Site with the reddit.com address and the foundation year of 2005.

class Site(val address: String, val foundationYear: Int)

// Write the makeReddit function here
fun makeReddit (): Site {
    val site = Site("reddit.com", 2005)
    return site
}
