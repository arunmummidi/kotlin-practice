import org.junit.jupiter.api.Assertions.*
import io.mockk.*

class AddNumbersTest {

    @Test
    fun `when adding 1 and 2 expect 3`() {
        val result = addNumbers(1,2)
        assertEquals(3, result)
    }
}

class IsEvenTest {

    @Test
    fun `when dividing 4 by 2 expect even number true` () {
        assertTrue(isEven(4))
    }
}

class MultiplytNumbersTest {

    @Test
    fun `when multiplying 2 and 3 expect 6` () {
        val result = multiplyNumbers(2, 3)
        assertEquals(6, result)
    }
}

class SubtractNumbersTest {

    @Test
    fun `when subtracting 2 from 3 expect 1` () {
        val result = subtractNumbers(3, 2)
        assertEquals(1, result)
    }
}
