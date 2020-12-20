import utils.splitBlankLines
import utils.splitNewlines
import utils.splitWhitespace

object Day19 {

    fun part1(input: String): Int {
        val (rules, messages) = parseInput(input)
        val string = generateRegexString(rules, 0)
        val regex = "^$string\$".toRegex()
        return messages.count { regex.matches(it) }
    }

    private fun generateRegexString(rules: Map<Int, String>, ruleId: Int): String {
        val rule = rules[ruleId]!!

        if (rule == "\"a\"" || rule == "\"b\"") {
            return rule.replace("\"", "")
        }

        val options = rule.split(" | ").joinToString(separator = "|") { option ->
            option.splitWhitespace().joinToString(separator = "") { generateRegexString(rules, it.toInt()) }
        }
        return "($options)"
    }

    private fun parseInput(input: String): Pair<Map<Int, String>, List<String>> {
        return input.splitBlankLines().let { (one, two) ->
            val rules = one.splitNewlines().associate { str ->
                val (key, value) = str.split(":")
                key.toInt() to value.trim()
            }
            val messages = two.splitNewlines().map(String::trim)
            rules to messages
        }
    }

    fun part2(input: String): Long {
        return -1
    }
}

