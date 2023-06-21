import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PersonTest {

    @Test
    fun testPersonCreationValidArgs() {
        val name = "Jane Doe"
        val age = Person.MIN_AGE + 23
        val person = Person(name, age)

        assertEquals(name, person.name)
        assertEquals(age, person.age)
    }

    @Test
    fun testPersonCreationNegativeAge() {
        val name = "Jane Doe"
        val age = Person.MIN_AGE - 1
        val person = Person(name, age)

        assertEquals(Person.MIN_AGE, person.age)
    }

    @Test
    fun testPersonCreationAgeOverUpperLimit() {
        val name = "Jane Doe"
        val age = Person.MAX_AGE + 1
        val person = Person(name, age)

        assertEquals(Person.MAX_AGE, person.age)
    }

    @Test
    fun testPersonCreationNameNull() {
        val name: String? = null
        val age = Person.MIN_AGE + 1
        val person = Person(name, age)

        assertNotNull(person.name)
        assertEquals(Person.DEFAULT_NAME, person.name)
    }

    @Test
    fun testPersonCreationNameBlank() {
        val name = "\t"
        val age = Person.MIN_AGE + 1
        val person = Person(name, age)

        assertEquals(Person.DEFAULT_NAME, person.name)
    }

    @Test
    fun testPersonCreationNameEmpty() {
        val name = ""
        val age = Person.MIN_AGE + 1
        val person = Person(name, age)

        assertEquals(Person.DEFAULT_NAME, person.name)
    }

}
