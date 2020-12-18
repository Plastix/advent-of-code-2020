import utils.splitNewlines

typealias Cube = Array<Slice>
typealias Slice = Array<BooleanArray>

object Day17 {

    private const val GRID_SIZE = 100

    fun part1(input: String): Int {
        val inputSlice = input.splitNewlines().map { it.toList().map { it == '#' } }
        var world: Cube = Array(GRID_SIZE) { index ->
            val array = Array(GRID_SIZE) { BooleanArray(GRID_SIZE) { false } }
            if (index == GRID_SIZE / 2) {
                inputSlice.forEachIndexed { i, list ->
                    list.forEachIndexed { j, b ->
                        val offset = (GRID_SIZE / 2) - (inputSlice.size / 2)
                        array[offset + i][offset + j] = b
                    }
                }
            }
            array
        }

        repeat(6) {
            world = world.simulateWorld()
        }

        return world.sumBy { slice -> slice.sumBy { row -> row.count { it } } }
    }

    private fun Cube.simulateWorld(): Cube {
        val newWorld: Cube = Array(GRID_SIZE) { index ->
            Array(GRID_SIZE) { BooleanArray(GRID_SIZE) { false } }
        }
        forEachIndexed { i, slice ->
            slice.forEachIndexed { j, list ->
                list.forEachIndexed { k, isActive ->
                    val activeNeighbors = countActiveNeighbors(i, j, k)
                    val newCellValue = when {
                        isActive && activeNeighbors in 2..3 -> true
                        !isActive && activeNeighbors == 3 -> true
                        else -> false
                    }
                    newWorld[i][j][k] = newCellValue
                }
            }
        }
        return newWorld
    }

    private fun Cube.countActiveNeighbors(i: Int, j: Int, k: Int): Int {
        return getAdjacents(i, j, k).count { (deltaI, deltaJ, deltaK) ->
            val slice = this.getOrNull(deltaI) ?: return@count false
            val row = slice.getOrNull(deltaJ) ?: return@count false
            row.getOrNull(deltaK) ?: false
        }
    }

    private fun getAdjacents(i: Int, j: Int, k: Int): List<Triple<Int, Int, Int>> {
        val delta = listOf(-1, 0, 1)
        val triples = mutableListOf<Triple<Int, Int, Int>>()
        for (deltaI in delta) {
            for (deltaJ in delta) {
                for (deltaK in delta) {
                    if (!(deltaI == 0 && deltaJ == 0 && deltaK == 0)) {
                        triples.add(Triple(i + deltaI, j + deltaJ, k + deltaK))
                    }
                }
            }
        }
        return triples
    }

    fun part2(input: String): Long {
        return -1
    }
}

