import utils.splitBlankLines
import utils.splitNewlines
import utils.splitWhitespace

object Day19 {

    fun solution(input: String): Int {
        val (rules, messages) = parseInput(input)
        val string = generateRegexString(rules, 0)
        val regex = "^$string\$".toRegex()
        return messages.count { regex.matches(it) }
    }

    private fun generateRegexString(rules: Map<Int, String>, ruleId: Int, depthLimit: Int = 15): String {
        val rule = rules[ruleId]!!
        return when {
            depthLimit == 0 -> ""
            rule == "\"a\"" || rule == "\"b\"" -> rule.replace("\"", "")
            else -> {
                val options = rule.split(" | ").joinToString(separator = "|") { option ->
                    option.splitWhitespace().joinToString(separator = "") { subrule ->
                        generateRegexString(rules, subrule.toInt(), depthLimit - 1)
                    }
                }
                "($options)"
            }
        }
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
}

