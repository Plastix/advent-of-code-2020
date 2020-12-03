import utils.splitNewlines
import utils.splitWhitespace

object Day2 {

    private val REGEX = Regex("(\\d+)-(\\d+) (.): (.+)")

    fun part1(input: String): Int {
        val inputs = input.splitNewlines()

        var count = 0
        inputs.forEach { line ->
            if (isValid(line)) {
                count++
            }
        }

        return count
    }

    private fun isValid(input: String): Boolean {
        val results = REGEX.matchEntire(input)!!.groupValues
        val min = results[1].toInt()
        val max = results[2].toInt()
        val char = results[3].first()
        val password = results[4]

        var count = 0
        password.forEach {
            if (char == it) {
                count++
            }
        }

        return count in min..max
    }

    fun part2(input: String): Int {
        val inputs = input.splitNewlines()

        var count = 0
        inputs.forEach { line ->
            if (isValid2(line)) {
                count++
            }
        }

        return count
    }

    private fun isValid2(input: String): Boolean {
        val results = REGEX.matchEntire(input)!!.groupValues
        val index1 = results[1].toInt() - 1
        val index2 = results[2].toInt() - 1
        val char = results[3].first()
        val password = results[4]

        return (password[index1] != char) xor (password[index2] != char)
    }


}
