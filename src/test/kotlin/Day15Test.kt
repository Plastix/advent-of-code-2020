import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day15Test {

    companion object {

        private val INPUT by lazy {
           "2,0,1,7,4,14,18"
        }

        private val SAMPLE = """
            0,3,6
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(436, Day15.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(496, Day15.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(175594, Day15.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(883, Day15.part2(INPUT))
    }
}
