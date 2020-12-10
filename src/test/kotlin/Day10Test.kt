import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day10Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day10.txt")
        }

        private val SAMPLE_LONG = """
           28
           33
           18
           42
           31
           14
           46
           20
           48
           47
           24
           23
           49
           45
           19
           38
           39
           11
           1
           32
           25
           35
           8
           17
           7
           9
           4
           2
           34
           10
           3
        """.trimIndent()

        private val SAMPLE_SHORT = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(220, Day10.part1(SAMPLE_LONG))
    }


    @Test
    fun `part 1 samples2`() {
        assertEquals(35, Day10.part1(SAMPLE_SHORT))
    }

    @Test
    fun `part 1`() {
        assertEquals(2046, Day10.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(8, Day10.part2(SAMPLE_SHORT))
    }

    @Test
    fun `part 2 samples2`() {
        assertEquals(19208, Day10.part2(SAMPLE_LONG))
    }

    @Test
    fun `part 2`() {
        assertEquals(0, Day10.part2(INPUT))
    }
}
