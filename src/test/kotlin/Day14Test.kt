import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day14Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day14.txt")
        }

        private val SAMPLE = """
           mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
           mem[8] = 11
           mem[7] = 101
           mem[8] = 0
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(165, Day14.part1(SAMPLE))
    }


    @Test
    fun `part 1`() {
        assertEquals(3059488894985, Day14.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(208, Day14.part2("""
            mask = 000000000000000000000000000000X1001X
            mem[42] = 100
            mask = 00000000000000000000000000000000X0XX
            mem[26] = 1
        """.trimIndent()))
    }

    @Test
    fun `part 2`() {
        assertEquals(2900994392308, Day14.part2(INPUT))
    }
}
