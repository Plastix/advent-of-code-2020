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

    fun part2(input: String, min: Long = 1): Long {
        val busses = input.splitNewlines().drop(1).first().split(",").mapIndexedNotNull { index, s ->
            val busId = s.toLongOrNull() ?: return@mapIndexedNotNull null
            busId to index
        }

        var timestep = min
        var step = 1L
        for ((busId, offset) in busses) {
            while ((timestep + offset) % busId != 0L) {
                timestep += step
            }
            step *= busId
        }
        return timestep
    }
}
