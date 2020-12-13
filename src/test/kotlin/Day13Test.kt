import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day13Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day13.txt")
        }

        private val SAMPLE = """
            939
            7,13,x,x,59,x,31,19
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(295, Day13.part1(SAMPLE))
    }


    @Test
    fun `part 1`() {
        assertEquals(6568, Day13.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(1068781, Day13.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(0, Day13.part2(INPUT, 100000000000001L))
    }
}
