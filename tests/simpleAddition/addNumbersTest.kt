import org.junit.jupiter.api.Assertions.*

class addNumbersTest {

    @org.junit.jupiter.api.Test
    fun `when adding 1 and 2 expect 3`() {
        val result = addNumbers(1,2)
        assertEquals(3, result)
    }
}
