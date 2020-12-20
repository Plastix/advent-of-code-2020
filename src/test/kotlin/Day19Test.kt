import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day19Test {

    companion object {

        private val INPUT by lazy {
            getResourceAsString("day19.txt")
        }

        private val SAMPLE = """
            0: 4 1 5
            1: 2 3 | 3 2
            2: 4 4 | 5 5
            3: 4 5 | 5 4
            4: "a"
            5: "b"

                ababbb
                bababa
                abbbab
                aaabbb
                aaaabbb
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(2, Day19.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(220, Day19.part1(INPUT))
    }

}
