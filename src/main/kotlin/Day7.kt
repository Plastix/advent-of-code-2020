import utils.splitNewlines
import java.util.*

object Day7 {

    private const val SHINY_GOLD = "shiny gold"

    private fun parseBagMap(input: String): Map<String, List<Pair<String, Int>>> {
        val bagKeyRegex = "(.+) bags contain (.+)".toRegex()
        val innerBagRegex = "(\\d)+ (\\D+) bags*[.,]".toRegex()

        return input.splitNewlines().associate { line ->
            val (key, items) = bagKeyRegex.matchEntire(line)!!.destructured
            val innerBags = innerBagRegex.findAll(items).map { match ->
                val (count, item) = match.destructured
                item to count.toInt()
            }.toList()

            key to innerBags
        }
    }

    fun part1(input: String): Int {
        return countShinyGoldBags(parseBagMap(input))
    }

    private fun countShinyGoldBags(bagMap: Map<String, List<Pair<String, Int>>>): Int {
        var count = 0
        for (entry in bagMap) {
            val queue: Queue<Pair<String, Int>> = LinkedList(entry.value)
            while (queue.isNotEmpty()) {
                val (key, _) = queue.poll()
                if (key == SHINY_GOLD) {
                    count++
                    break
                } else {
                    queue.addAll(bagMap[key] ?: emptyList())
                }
            }
        }
        return count
    }


    fun part2(input: String): Int {
        return countInnerBags(parseBagMap(input))
    }

    private fun countInnerBags(bagMap: Map<String, List<Pair<String, Int>>>): Int {
        var count = 0
        val queue: Queue<Pair<String, Int>> = LinkedList(bagMap[SHINY_GOLD] ?: emptyList())

        while (queue.isNotEmpty()) {
            val (key, innerCount) = queue.poll()
            count += innerCount

            repeat(innerCount) {
                queue.addAll(bagMap[key] ?: emptyList())
            }
        }

        return count
    }
}
