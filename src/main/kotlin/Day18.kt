import utils.splitNewlines
import utils.splitWhitespace
import java.lang.Integer.max

object Day18 {

    fun part1(input: String): Long {
        return input.splitNewlines().map(this::evaluateExpression).sum()
    }

    private fun evaluateExpression(line: String): Long {
        val stack = mutableListOf<String>()
        line.splitWhitespace().forEach { token ->
            stack.add(token)
            while (stack.size >= 3) {
                val (one, operand, two) = stack.takeLast(3)
                if (operand in setOf("*", "+") && !two.contains("(")) {
                    repeat(3) {
                        stack.removeLast()
                    }
                    val newNum = when (operand) {
                        "*" -> one.removeOpenParans().toLong() * two.removeCloseParans().toLong()
                        "+" -> one.removeOpenParans().toLong() + two.removeCloseParans().toLong()
                        else -> error("Unknown operand $operand")
                    }
                    if (one.contains("(") && !two.contains(")")) {
                        val openCount = one.count { it == '(' }
                        val opening = "(".repeat(openCount)
                        stack.add("$opening$newNum")
                    } else {
                        val openCount = one.count { it == '(' }
                        val closeCount = two.count { it == ')' }
                        val opening = "(".repeat(max(0, openCount - 1))
                        val closing = ")".repeat(max(0, closeCount - 1))
                        stack.add("$opening$newNum$closing")
                    }
                } else {
                    break // No expression able to be evaluated
                }
            }
        }
        assert(stack.size == 1) {
            """Stack contains more than one value left!
               expression = $line
               stack      = $stack
            """.trimMargin()

        }
        return stack.last().toLong()
    }

    private fun String.removeOpenParans(): String {
        return replace("(", "")
    }

    private fun String.removeCloseParans(): String {
        return replace(")", "")
    }

    fun part2(input: String): Long {
        return -1
    }
}

