import utils.splitNewlines

object Day13 {

    fun part1(input: String): Int {
        val lines = input.splitNewlines()
        val departureTime = lines.first().toInt()
        val (earliestBus, offset) = lines[1].split(",").mapNotNull {
            val busId = it.toIntOrNull() ?: return@mapNotNull null
            busId to (departureTime % busId)
        }.maxByOrNull { it.second }!!
        return earliestBus * (earliestBus - offset)
    }

    fun part2(input: String, min: Long = 0): Long {
        TODO()
    }
}
