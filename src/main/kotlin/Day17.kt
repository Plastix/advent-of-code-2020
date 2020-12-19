import utils.splitNewlines

typealias Cube = Array<Slice>
typealias Slice = Array<BooleanArray>

object Day17 {

    private const val GRID_SIZE = 30

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

        return world.countActive()
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

    private fun Cube.countActive(): Int {
        return sumBy { slice -> slice.sumBy { row -> row.count { it } } }
    }

    data class Coordinate(
            val x: Int,
            val y: Int,
            val z: Int,
            val w: Int
    ) {
        override fun toString(): String {
            return "($x, $y, $z, $w)"
        }
    }

    fun part2(input: String): Int {
        val inputSlice = input.splitNewlines().map { it.toList().map { it == '#' } }
        val world = mutableSetOf<Coordinate>()
        inputSlice.forEachIndexed { x, row ->
            row.forEachIndexed { y, boolean ->
                if (boolean) {
                    world.add(Coordinate(x, y, 0, 0))
                }
            }
        }

        repeat(6) {
            val newWorld = mutableSetOf<Coordinate>()
            for (x in -15..15) {
                for (y in -15..15) {
                    for (z in -15..15) {
                        for (w in -15..15) {
                            val delta = listOf(-1, 0, 1)
                            var neighbors = 0
                            for (dx in delta) {
                                for (dy in delta) {
                                    for (dz in delta) {
                                        for (dw in delta) {
                                            if (!(dx == 0 && dy == 0 && dz == 0 && dw == 0)) {
                                                val check = Coordinate(x + dx, y + dy, z + dz, w + dw)
                                                if (check in world) {
                                                    neighbors += 1
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            val currentCoord = Coordinate(x, y, z, w)
                            val isActive = currentCoord in world
                            val newActive = when {
                                isActive && neighbors  in 2..3 -> true
                                !isActive && neighbors == 3 -> true
                                else -> false
                            }
                            if (newActive) {
                                newWorld.add(currentCoord)
                            }
                        }
                    }
                }
            }
            world.clear()
            world.addAll(newWorld)
        }
        return world.count()
    }
}

