import utils.splitBlankLines
import utils.splitCommas
import utils.splitNewlines
import utils.toIntList

typealias Ticket = List<Int>
typealias DisjointRanges = List<IntRange>

object Day16 {

    fun part1(input: String): Int {
        val (ranges, _, nearbyTickets) = parseInput(input)
        return nearbyTickets.flatMap { ticket ->
            ticket.filterNot { number -> ranges.any { number.inDisjointRanges(it) } }
        }.sum()
    }

    private fun Int.inDisjointRanges(ranges: DisjointRanges): Boolean {
        return ranges.any { range -> this in range }
    }

    private fun parseInput(input: String): Triple<List<DisjointRanges>, Ticket, List<Ticket>> {
        return input.splitBlankLines().let { (one, two, three) ->
            Triple(
                    one.splitNewlines().map { line ->
                        line.split(":").last().split("or").map { rangeString ->
                            val (min, max) = rangeString.trim().split("-").toIntList()
                            min..max
                        }
                    },
                    two.splitNewlines().last().splitCommas().toIntList(),
                    three.splitNewlines().drop(1).map { ticketString -> ticketString.splitCommas().toIntList() }
            )
        }
    }


    fun part2(input: String): Long {
        val (ranges, yourTicket, nearbyTickets) = parseInput(input)
        val validTickets: List<List<Int>> = nearbyTickets.filter { ticket ->
            ticket.all { num -> ranges.any { range -> num.inDisjointRanges(range) } }
        }

        val ticketSize = validTickets.first().size
        val options = mutableListOf<MutableSet<Int>>()
        repeat(ticketSize) {
            options.add(mutableSetOf())
        }
        for (i in 0 until ticketSize) {
            val column = validTickets.map { it[i] }
            options[i] = ranges.mapIndexedNotNull { index, range ->
                if (column.all { num -> num.inDisjointRanges(range) }) {
                    index
                } else {
                    null
                }
            }.toMutableSet()
        }

        val indicies = mutableMapOf<Int, Int>()
        while (indicies.size != ticketSize) {
            options.forEachIndexed { index, set ->
                if (set.size == 1) {
                    val value = set.first()
                    indicies[index] = value
                    options.forEach { s -> s.remove(value) }
                }
            }
        }

        return indicies.entries.fold(1L) { acc, (key, value) ->
            if (value <= 5) {
                acc * yourTicket[key]
            } else {
                acc
            }
        }
    }
}
