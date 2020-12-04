import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day3Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day3.txt")
        }

        private val SAMPLE = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(7, Day3.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(232, Day3.part1(INPUT))
    }

    @Test
    fun `part 2 samples`() {
        assertEquals(336, Day3.part2(SAMPLE))
    }

    @Test
    fun `part 2`() {
        assertEquals(3952291680, Day3.part2(INPUT))
    }
}
