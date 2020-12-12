import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day12Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day12.txt")
        }

        private val SAMPLE = """
F10
N3
F7
R90
F11
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(25, Day12.part1(SAMPLE))
    }


    @Test
    fun `part 1`() {
        assertEquals(759, Day12.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(286, Day12.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(45763, Day12.part2(INPUT))
    }
}
