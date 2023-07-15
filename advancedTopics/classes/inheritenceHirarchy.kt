/*inheritance hierarchy
Animal
        - Mammal
            - Lion
        - Fish
            - Salmon
            - Carp
        - Bird
            - Eagle
Implement this hierarchy in your program.*/
// write here
open class Animal
open class Mammal : Animal()
open class Fish : Animal()
open class Bird : Animal()
class Lion : Mammal()
class Salmon : Fish()
class Carp : Fish()
class Eagle : Bird()
