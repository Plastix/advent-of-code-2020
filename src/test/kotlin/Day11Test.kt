import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day11Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day11.txt")
        }

        private val SAMPLE = """
           L.LL.LL.LL
           LLLLLLL.LL
           L.L.L..L..
           LLLL.LL.LL
           L.LL.LL.LL
           L.LLLLL.LL
           ..L.L.....
           LLLLLLLLLL
           L.LLLLLL.L
           L.LLLLL.LL
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(37, Day11.part1(SAMPLE))
    }


    @Test
    fun `part 1`() {
        assertEquals(2254, Day11.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(26, Day11.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(2004, Day11.part2(INPUT))
    }
}
