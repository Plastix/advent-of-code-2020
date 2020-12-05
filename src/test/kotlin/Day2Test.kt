import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day2Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day2.txt")
        }
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(2, Day2.part1("""
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent()))
    }

    @Test
    fun `part 1`() {
        assertEquals(424, Day2.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(1, Day2.part2("""
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent()))
    }

    @Test
    fun `part 2`() {
        assertEquals(747, Day2.part2(INPUT))
    }
}
