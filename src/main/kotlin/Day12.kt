import utils.splitNewlines
import kotlin.math.abs

object Day12 {

    fun part1(input: String): Int {
        val dirMap = mapOf(0 to 'E', 90 to 'N', 180 to 'W', 270 to 'S')
        var x = 0
        var y = 0
        var dir = 0
        for (line in input.splitNewlines()) {
            fun runCommand(cmd: Char, num: Int) {
                when (cmd) {
                    'N' -> y -= num
                    'S' -> y += num
                    'E' -> x += num
                    'W' -> x -= num
                    'L' -> dir = (dir + num) % 360
                    'R' -> dir = (dir - num + 360) % 360
                    'F' -> runCommand(dirMap[dir]!!, num)
                }
            }
            runCommand(line[0], line.drop(1).toInt())
        }
        return abs(x) + abs(y)
    }

    fun part2(input: String): Int {
        var wx = 10
        var wy = -1
        var x = 0
        var y = 0
        for (line in input.splitNewlines()) {
            val num = line.drop(1).toInt()
            when (line[0]) {
                'N' -> wy -= num
                'S' -> wy += num
                'E' -> wx += num
                'W' -> wx -= num
                'L' -> repeat(num / 90) {
                    val temp = wx
                    wx = wy
                    wy = -temp
                }
                'R' -> repeat(num / 90) {
                    val temp = wx
                    wx = -wy
                    wy = temp
                }
                'F' -> {
                    x += wx * num
                    y += wy * num
                }
            }
        }
        return abs(x) + abs(y)
    }
}
