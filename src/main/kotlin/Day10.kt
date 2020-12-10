import utils.splitNewlines
import utils.toIntList
import kotlin.math.abs

object Day10 {

    fun part1(input: String): Int {
        return getJoltOrdering(input).windowed(2).let { pairs ->
            val ones = pairs.count(diffOf(1))
            val threes = pairs.count(diffOf(3))
            ones * threes
        }
    }

    private fun getJoltOrdering(input: String): List<Int> {
        return mutableListOf(0).apply {
            val nums = input.splitNewlines().toIntList().sorted()
            addAll(nums)
            add(nums.maxOrNull()!! + 3)
        }
    }

    private fun diffOf(diff: Int): (List<Int>) -> Boolean {
        return { (one, two) -> abs(one - two) == diff }
    }

    fun part2(input: String): Long {
        val nums = getJoltOrdering(input)

        val table = mutableMapOf<Int, Long>()

        fun recurse(index: Int): Long {
            if(index == nums.size - 1) {
                return 1
            }

            val found = table[index]
            if(found != null) {
                return found
            }

            var count = 0L
            for(i in index+1 until nums.size) {
                if(abs(nums[i] - nums[index]) <= 3) {
                    count += recurse(i)
                }
            }
            table[index] = count
            return count
        }

        return recurse(0)
    }
}
