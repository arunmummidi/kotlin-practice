import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class subtractNumbersTest {

    @Test
    fun `when subtracting 2 from 3 expect 1` () {
        val result = subtractNumbers(3, 2)
        assertEquals(1, result)
    }
}
