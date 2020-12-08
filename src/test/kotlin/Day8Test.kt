import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day8Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day8.txt")
        }

        private val SAMPLE = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(5, Day8.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(1723, Day8.part1(INPUT))
    }


    @Test
    fun `part 2 samples`() {
        assertEquals(8, Day8.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(846, Day8.part2(INPUT))
    }
}
