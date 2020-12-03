import utils.splitWhitespace

object Day1 {

    fun part1(input: String): Int {
        val nums = input.intList()
        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            map[2020 - num] = num

            if (map.containsKey(num)) {
                return num * map[num]!!
            }
        }

        return -1
    }

    private fun String.intList(): List<Int> = splitWhitespace()
            .map { string -> string.toInt() }

    fun part2(input: String): Int {
        val nums = input.intList()

        nums.forEach { num1 ->
            nums.forEach { num2 ->
                nums.forEach { num3 ->
                    if (num1 + num2 + num3 == 2020) {
                        return num1 * num2 * num3
                    }
                }
            }
        }
        return -1
    }

}
