import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day1Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day1.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(514579, Day1.part1("""
            1721
            979
            366
            299
            675
            1456
        """.trimIndent()))
    }

    @Test
    fun `part 1`() {
        assertEquals(969024, Day1.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(241861950, Day1.part2("""
            1721
            979
            366
            299
            675
            1456
        """.trimIndent()))
    }

    @Test
    fun `part 2`() {
        assertEquals(230057040, Day1.part2(INPUT))
    }
}
