import utils.splitNewlines

object Day5 {

    fun part1(input: String): Int {
        return input.splitNewlines().map(this::calculateSeatId).maxOrNull() ?: error("No seat id!")
    }

    private fun calculateSeatId(seatEncoding: String): Int {
        val row: Int = calculatePartition(seatEncoding.take(7), 0..127, 'F', 'B')
        val column: Int = calculatePartition(seatEncoding.takeLast(3), 0..7, 'L', 'R')
        return row * 8 + column
    }

    private fun calculatePartition(chars: String, range: IntRange, lower: Char, upper: Char): Int {
        return chars.fold(range) { acc, char ->
            when (char) {
                lower -> acc.lowerHalf()
                upper -> acc.upperHalf()
                else -> error("Unknown char!")
            }
        }.first
    }

    private fun IntRange.midpoint(): Int = start + ((endInclusive - start) / 2)
    private fun IntRange.upperHalf(): IntRange = (midpoint() + 1)..endInclusive
    private fun IntRange.lowerHalf(): IntRange = start..midpoint()

    fun part2(input: String): Int {
        val seatIds = input.splitNewlines().map(this::calculateSeatId).toSet()

        val min = seatIds.minOrNull()!!
        val max = seatIds.maxOrNull()!!

        return (min..max).first { id ->
            !seatIds.contains(id) && seatIds.contains(id - 1) && seatIds.contains(id + 1)
        }
    }
}
