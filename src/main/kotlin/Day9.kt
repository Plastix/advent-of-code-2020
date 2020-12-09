import utils.splitNewlines
import utils.toLongList

object Day9 {

    fun part1(input: String, preambleLength: Int): Long {
        return input.splitNewlines().toLongList()
                .windowed(preambleLength + 1)
                .mapNotNull { sequence ->
                    val numbers = sequence.dropLast(1)
                    val target = sequence.last()

                    var doesSum = false
                    for (i in numbers) {
                        for (j in numbers) {
                            if (i != j && i + j == target) {
                                doesSum = true
                                break
                            }
                        }
                    }

                    if (doesSum) {
                        null
                    } else {
                        target
                    }
                }
                .first()
    }

    fun part2(input: String, target: Long): Long {
        val numbers = input.splitNewlines().toLongList()

        val maxIndex = numbers.size - 1
        val table: Array<Array<Long>> = Array(numbers.size) { Array(numbers.size) { 0 } }
        for (startIndex in 0..maxIndex) {
            table[startIndex][0] = numbers[startIndex]
            for (endIndex in startIndex..maxIndex) {
                val prevValue = table[startIndex].getOrElse(endIndex - 1) { 0L }
                val newValue = prevValue + numbers[endIndex]
                table[startIndex][endIndex] = newValue

                if(newValue == target) {
                    val range = numbers.subList(startIndex + 1, endIndex + 2)
                    return range.minOrNull()?.plus(range.maxOrNull() ?: 0) ?: -1
                }
            }
        }

        return -1
    }
}
