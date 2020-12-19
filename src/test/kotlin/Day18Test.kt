import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day18Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day18.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(71, Day18.part1("1 + 2 * 3 + 4 * 5 + 6"))
        assertEquals(51, Day18.part1("1 + (2 * 3) + (4 * (5 + 6))"))
        assertEquals(26, Day18.part1("2 * 3 + (4 * 5)"))
        assertEquals(437, Day18.part1("5 + (8 * 3 + 9 + 3 * 4 * 3)"))
        assertEquals(12240, Day18.part1("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"))
        assertEquals(13632, Day18.part1("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"))
        assertEquals(3160, Day18.part1("8 * ((6 + 8 * 3 * 9) + 9 + 8)"))
    }

    @Test
    fun `part 1`() {
        assertEquals(5019432542701, Day18.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(231, Day18.part2("1 + 2 * 3 + 4 * 5 + 6"))
    }

    @Test
    fun `part 2`() {
        assertEquals(0, Day18.part2(INPUT))
    }
}
