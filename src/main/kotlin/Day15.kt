import utils.splitCommas
import utils.toIntList

object Day15 {

    fun part1(input: String): Int {
        return nthSequenceNumber(input, 2020)
    }

    private fun nthSequenceNumber(input: String, n: Int): Int {
        val nums = input.splitCommas().toIntList()
        val lastSeenAt = mutableMapOf(*nums.dropLast(1).zip(nums.indices).toTypedArray())
        var lastNumber = nums.last()
        for (index in nums.size - 1 until n - 1) {
            val previousIndex = lastSeenAt[lastNumber]
            lastSeenAt[lastNumber] = index
            lastNumber = if (previousIndex == null) 0 else index - previousIndex
        }
        return lastNumber
    }


    fun part2(input: String): Int {
        return nthSequenceNumber(input, 30000000)
    }
}
