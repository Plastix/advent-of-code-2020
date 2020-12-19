import utils.splitNewlines
import utils.splitWhitespace

object Day18 {

    fun part1(input: String): Long {
        return input.splitNewlines()
                .map(this::padParens)
                .map(this::evaluateExpression)
                .sum()
    }

    private fun padParens(string: String): String = string.replace("(", "( ").replace(")", " )")

    private fun String.isParen(): Boolean = this == ")" || this == "("

    private fun String.isOperand(): Boolean = this == "*" || this == "+"

    private fun <T> MutableList<T>.removeLast(number: Int) = repeat(number) { this.removeLast() }

    private fun evaluateExpression(line: String): Long {
        val stack = mutableListOf<String>()
        line.splitWhitespace().forEach { token ->
            stack.add(token)
            while (stack.size >= 3) {
                val (one, two, three) = stack.takeLast(3)
                when {
                    !two.isOperand() && one.isParen() && three.isParen() -> stack.apply {
                        removeLast(3)
                        add(two) // ( num ) -> num
                    }
                    two.isOperand() && !one.isParen() && !three.isParen() -> stack.apply {
                        removeLast(3)
                        val newNum = when (two) {
                            "*" -> one.toLong() * three.toLong()
                            "+" -> one.toLong() + three.toLong()
                            else -> error("Unknown operand $two")
                        }.toString()
                        add(newNum) // 1 + 1 -> 2
                    }
                    else -> break // Nothing to evaluate
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

    fun part2(input: String): Long {
        return -1
    }
}

