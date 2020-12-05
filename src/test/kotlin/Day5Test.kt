import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day5Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day5.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(357, Day5.part1("FBFBBFFRLR"))
        assertEquals(567, Day5.part1("BFFFBBFRRR"))
        assertEquals(119, Day5.part1("FFFBBBFRRR"))
        assertEquals(820, Day5.part1("BBFFBBFRLL"))
    }

    @Test
    fun `part 1`() {
        assertEquals(885, Day5.part1(INPUT))
    }

    @Test
    fun `part 2`() {
        assertEquals(623, Day5.part2(INPUT))
    }
}
