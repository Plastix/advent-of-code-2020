import utils.splitBlankLines
import utils.splitNewlines

object Day6 {

    fun part1(input: String): Int {
        return input.splitBlankLines().map { group ->
            group.replace("\n", "").toSet().size
        }.sum()
    }

    fun part2(input: String): Int {
        return input.splitBlankLines().map { group ->
            group.splitNewlines().map(String::toSet)
                    .reduce { acc, set -> acc.intersect(set) }.count()
        }.sum()
    }
}
