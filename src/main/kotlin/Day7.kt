import utils.splitNewlines
import java.util.*

object Day7 {

    private const val SHINY_GOLD = "shiny gold"

    private fun parseBagMap(input: String): MutableMap<String, List<Pair<String, Int>>> {
        val bagKeyRegex = Regex("(.+) bags contain (.+)")
        val innerBagRegex = Regex("(\\d)+ (\\D+) bags*[.,]")

        val bagMap: MutableMap<String, List<Pair<String, Int>>> = mutableMapOf()
        input.splitNewlines().forEach { definition ->
            val match = bagKeyRegex.matchEntire(definition)!!.groupValues
            val key = match[1]
            val innerBags = innerBagRegex.findAll(match[2]).map {
                it.groupValues[2] to it.groupValues[1].toInt()
            }.toList()
            bagMap[key] = innerBags
        }

        return bagMap
    }

    fun part1(input: String): Int {
        return countShinyGoldBags(parseBagMap(input))
    }

    private fun countShinyGoldBags(bagMap: MutableMap<String, List<Pair<String, Int>>>): Int {
        var count = 0
        for (entry in bagMap) {
            val queue: Queue<Pair<String, Int>> = LinkedList(entry.value)
            while (queue.isNotEmpty()) {
                val pair = queue.poll()
                if (pair.first == SHINY_GOLD) {
                    count++
                    break
                } else {
                    queue.addAll(bagMap[pair.first] ?: emptyList())
                }
            }
        }
        return count
    }


    fun part2(input: String): Int {
        return countInnerBags(parseBagMap(input))
    }

    private fun countInnerBags(bagMap: MutableMap<String, List<Pair<String, Int>>>): Int {
        var count = 0
        val queue: Queue<Pair<String, Int>> = LinkedList(bagMap[SHINY_GOLD] ?: emptyList())

        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            count += pair.second

            repeat(pair.second) {
                queue.addAll(bagMap[pair.first] ?: emptyList())
            }
        }

        return count
    }
}
