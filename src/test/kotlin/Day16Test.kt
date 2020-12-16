import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day16Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day16.txt")
        }

        private val SAMPLE = """
            class: 1-3 or 5-7
            row: 6-11 or 33-44
            seat: 13-40 or 45-50

            your ticket:
            7,1,14

            nearby tickets:
            7,3,47
            40,4,50
            55,2,20
            38,6,12
        """.trimIndent()

        private val SAMPLE2 = """
            class: 0-1 or 4-19
            row: 0-5 or 8-19
            seat: 0-13 or 16-19
            
            your ticket:
            11,12,13
            
            nearby tickets:
            3,9,18
            15,1,5
            5,14,9
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(71, Day16.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(29019, Day16.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(1716, Day16.part2(SAMPLE2))
    }

    @Test
    fun `part 2`() {
        assertEquals(517827547723, Day16.part2(INPUT))
    }
}
