import utils.splitNewlines
import utils.splitWhitespace

object Day3 {

    fun part1(input: String): Int {
        val trees = parseInput(input)

        return countTrees(trees, 3, 1)
    }

    private fun parseInput(input: String): List<List<Boolean>> {
        return input.splitNewlines().map { string ->
            string.map { it == '#' }
        }
    }

    private fun countTrees(input: List<List<Boolean>>, stepX: Int, stepY: Int): Int {
        var count = 0

        var x = 0
        var y = 0
        while (y < input.size) {
            if (input[y][x]) {
                count++
            }

            x += stepX
            x %= input[y].size
            y += stepY
        }

        return count
    }

    fun part2(input: String): Long {
        val trees = parseInput(input)

        val steps = listOf(
                1 to 1,
                3 to 1,
                5 to 1,
                7 to 1,
                1 to 2
        )

        return steps.map { (x, y) ->
            countTrees(trees, x, y)
        }.fold(1L) { product, num ->
            product * num
        }
    }
}
