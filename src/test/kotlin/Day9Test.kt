import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day9Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day9.txt")
        }

        private val SAMPLE = """
           35
           20
           15
           25
           47
           40
           62
           55
           65
           95
           102
           117
           150
           182
           127
           219
           299
           277
           309
           576
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(127, Day9.part1(SAMPLE, 5))
    }

    @Test
    fun `part 1`() {
        assertEquals(248131121, Day9.part1(INPUT, 25))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(62, Day9.part2(SAMPLE, 127))
    }

    @Test
    fun `part 2`() {
        assertEquals(31580383, Day9.part2(INPUT, 248131121))
    }
}
