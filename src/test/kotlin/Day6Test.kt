import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day6Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day6.txt")
        }

        private val SAMPLE = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(11, Day6.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(6549, Day6.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(6, Day6.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(3466, Day6.part2(INPUT))
    }
}
