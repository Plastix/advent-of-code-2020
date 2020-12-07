import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day7Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day7.txt")
        }

        private val SAMPLE by lazy {
            getResourceAsString("day7-sample.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(4, Day7.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(296, Day7.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(32, Day7.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(9339, Day7.part2(INPUT))
    }
}
