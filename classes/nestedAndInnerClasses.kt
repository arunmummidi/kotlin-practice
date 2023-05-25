// Below you can see the code for the Hero and Villain classes. We want to print some information about these characters to the console. Complete four lines of code in the main function to make it possible: assign the equipment values and calculate the total strength of the characters by adding the weaponStrength to the baseStrength.
// Nested and inner classes
class Hero {
    val baseStrength = 1000
    class Equipment {
        val weapon = "trident"
        val weaponStrength = 300
    }
}

class Villain {
    val baseStrength = 500
    class Equipment {
        val weapon = "bomb"
        val weaponStrength = 700
    }
}

fun main() {
    val heroEquipment = Hero.Equipment()
    val heroTotalStrength = Hero().baseStrength + heroEquipment.weaponStrength

    val villainEquipment = Villain.Equipment()
    val villainTotalStrength = Villain().baseStrength + villainEquipment.weaponStrength

    // the following lines should remain as they are
    println("The hero uses ${heroEquipment.weapon}. The total strength is $heroTotalStrength.")
    println("The villain uses ${villainEquipment.weapon}. The total strength is $villainTotalStrength.")
}