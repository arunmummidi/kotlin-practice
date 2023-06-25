import java.io.File
import kotlin.system.exitProcess

val seperator = File.separator
val e = Exception()

fun main() {
    val configFile = seperator + "tmp" + seperator + "InventoryConfig"
    try {
        File(configFile).createNewFile()
    } catch (e: Exception) {
        println("Could not create File $configFile. Exiting")
        println(message = e.message)
        exitProcess(1)
    }
    setUser(configFile)

    val inventorySet = mutableSetOf<MutableList<String>>()
    showMenu(inventorySet)
}

fun showMenu(inventorySet: MutableSet<MutableList<String>>) {

    println("""
        show - Show full inventory
        add - Add an item to the inventory
        remove - Remove an item from the inventory
        search - Search for an item in the inventory
        exit - Exit the program
    """.trimIndent())
    when(readln().lowercase()) {
        "show" -> showInventory(inventorySet)
        "add" -> {
            val itemSet = addItem(inventorySet)
            inventorySet.add(itemSet)
            println("Added $itemSet to the inventory")

            println("Inventory contains $inventorySet")
            showMenu(inventorySet)
        }
        "remove" -> removeItem(inventorySet)
        "search" -> searchItem(inventorySet)
        "exit" -> exitProcess(0)
        else -> showMenu(inventorySet)
    }
}

fun showInventory(inventorySet: MutableSet<MutableList<String>>) {
    println("Displaying inventory")
    println(inventorySet.toString())
    showMenu(inventorySet)
}

fun setUser(configFile: String) {
    println("Enter your name:")
    try{
        File(configFile).writeText(readln())
    } catch (e: Exception) {
        println("Could not write to file $configFile")
    }
}

fun addItem(inventorySet: MutableSet<MutableList<String>>):MutableList<String> {
    println("name:")
    val name = readln()

    if (inventorySet.contains(mutableListOf(name))) {
        println("The item already exists. Exiting.")
        exitProcess(0)
    }

    println("count")
    val count = readln()

    val itemProperties = mutableListOf<String>(name, count)
    return itemProperties
}

fun removeItem(inventorySet: MutableSet<MutableList<String>>) {
    println("name:")
    val itemName = readln()
    println("Removing items.")
    inventorySet.removeIf { it[0] == itemName }
    showMenu(inventorySet)
}

fun searchItem(inventorySet: MutableSet<MutableList<String>>) {
    println("Searching items.")
    showMenu(inventorySet)
}
