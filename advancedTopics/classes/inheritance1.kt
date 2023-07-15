// Choose the correct cases of inheritance:
fun main() {

}

//open class Product(price: Int, name: String)
//
//class Milk(price: Int, name: String) : Product(price, name)

open class Product(price: Int, name: String)

class Kombucha(price: Int, volume: Int, name: String) : Product(price, name)
//
//open class Product(price: Int, name: String)
//
//class Juice(price: Int, name: String) : Product(price)

//open class Product(price: Int, name: String)
//
//class Water() : Product(price, name)