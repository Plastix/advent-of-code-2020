import utils.splitNewlines
import utils.toIntList
import kotlin.math.abs

object Day10 {

    fun part1(input: String): Int {
        val nums = getJoltOrdering(input)

        val chain = mutableListOf(0)
        for (element in nums) {
            if (chain.last() - element <= 3) {
                chain.add(element)
            }
        }

        return chain.windowed(2).let { pairs ->
            val ones = pairs.count(diffOf(1))
            val threes = pairs.count(diffOf(3))
            ones * threes
        }
    }

    private fun getJoltOrdering(input: String): List<Int> {
        val nums = input.splitNewlines().toIntList()
        val myJolt = nums.maxOrNull()!! + 3
        return nums.sorted().plus(myJolt)
    }

    private fun diffOf(diff: Int): (List<Int>) -> Boolean {
        return { (one, two) -> abs(one - two) == diff }
    }


    fun part2(input: String): Int {
        TODO()
    }
}
