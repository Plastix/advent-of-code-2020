package utils

import java.util.regex.Pattern

/**
 * Convenience methods for manipulating string inputs.
 *
 * Generally forgiving of whitespace.
 * From: https://github.com/dlew/aoc-2017
 */

private val NEWLINE = Pattern.compile("\\r?\\n")
private val WHITESPACE = Pattern.compile("\\s+")
private val COMMA = Pattern.compile(",\\s*")

fun CharSequence.splitNewlines(): List<String> {
    return trim().split(NEWLINE)
}

fun CharSequence.splitBlankLines(): List<String> {
    return trim().split("\n\n")
}

fun CharSequence.splitWhitespace(): List<String> {
    return trim().split(WHITESPACE)
}

fun CharSequence.splitCommas(): List<String> {
    return trim().split(COMMA)
}

fun String.toIntList(): List<Int> {
    return trim().map { it.toString().toInt() }
}

fun CharArray.toIntList(): List<Int> {
    return map { it.toString().toInt() }
}

fun List<String>.toIntList(): List<Int> {
    return map { it.trim().toInt() }
}

fun getResourceAsString(resourceName: String): String {
    return object {}.javaClass.classLoader.getResource(resourceName).readText()
}