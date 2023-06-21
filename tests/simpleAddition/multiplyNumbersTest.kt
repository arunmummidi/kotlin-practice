import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class multiplytNumbersTest {

    @Test
    fun `when multiplying 2 and 3 expect 6` () {
        val result = multiplyNumbers(2, 3)
        assertEquals(6, result)
    }
}
