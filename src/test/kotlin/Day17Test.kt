import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day17Test {

    companion object {

        private val INPUT = """
            ...#..#.
            ..##.##.
            ..#.....
            ....#...
            #.##...#
            ####..##
            ...##.#.
            #.#.#...
        """.trimIndent()

        private val SAMPLE = """
            .#.
            ..#
            ###
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(112, Day17.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(247, Day17.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(0, Day17.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(0, Day17.part2(INPUT))
    }
}
