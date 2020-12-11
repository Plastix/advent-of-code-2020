import utils.splitNewlines

typealias CountFunction = (grid: List<List<Seat>>, i: Int, j: Int) -> Int

enum class Seat {
    Empty, Floor, Occupied
}

object Day11 {

    private val directions = listOf(
            -1 to 0,
            1 to 0,
            0 to -1,
            0 to 1,
            -1 to -1,
            1 to 1,
            -1 to 1,
            1 to -1
    )

    private fun parseInput(input: String): List<List<Seat>> {
        return input.splitNewlines().map { string ->
            string.map {
                when (it) {
                    'L' -> Seat.Empty
                    else -> Seat.Floor
                }
            }
        }
    }

    fun part1(input: String): Int {
        val grid = parseInput(input)

        var current = grid
        while (true) {
            val next = simulateGrid(current, this::countAdjacent, 4)
            if (next == current) {
                return current.countOccupied()
            }
            current = next
        }
    }

    private fun simulateGrid(grid: List<List<Seat>>, func: CountFunction, limit: Int): List<List<Seat>> {
        return grid.mapIndexed { i, list ->
            list.mapIndexed { j, seat ->
                val neighbors = func(grid, i, j)
                when {
                    seat == Seat.Empty && neighbors == 0 -> Seat.Occupied
                    seat == Seat.Occupied && neighbors >= limit -> Seat.Empty
                    else -> seat
                }
            }
        }
    }

    private fun List<List<Seat>>.countOccupied(): Int {
        return sumBy { row -> row.count { seat -> seat == Seat.Occupied } }
    }

    private fun countAdjacent(grid: List<List<Seat>>, i: Int, j: Int): Int {
        return directions.count { dir ->
            val x = i + dir.first
            val y = j + dir.second
            x in grid.indices && y in grid[x].indices && grid[x][y] == Seat.Occupied
        }
    }

    fun part2(input: String): Int {
        val grid = parseInput(input)

        var current = grid
        while (true) {
            val next = simulateGrid(current, this::countVisible, 5)
            if (next == current) {
                return current.countOccupied()
            }
            current = next
        }
    }

    private fun countVisible(grid: List<List<Seat>>, i: Int, j: Int): Int {
        return directions.count { dir ->
            var x = i + dir.first
            var y = j + dir.second
            while (x in grid.indices && y in grid[x].indices) {
                when (grid[x][y]) {
                    Seat.Occupied -> return@count true
                    Seat.Empty -> return@count false
                    Seat.Floor -> {
                        x += dir.first
                        y += dir.second
                    }
                }
            }
            false
        }
    }

}
