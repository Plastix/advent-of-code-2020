object Day4 {

    private val requiredFields = listOf(
            "byr" to Regex("(19[2-8][0-9]|199[0-9]|200[0-2])"),
            "iyr" to Regex("(201[0-9]|2020)"),
            "eyr" to Regex("(202[0-9]|2030)"),
            "hgt" to Regex("(1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in"),
            "hcl" to Regex("#([a-f]|[0-9]){6}"),
            "ecl" to Regex("amb|blu|brn|gry|grn|hzl|oth"),
            "pid" to Regex("\\d{9}"),
    )

    fun part1(input: String): Int {
        val passports = input.trim().split("\n\n")
        return passports.filter(::isValid).count()
    }

    private fun isValid(passport: String): Boolean {
        requiredFields.forEach { field ->
            if (!passport.contains(field.first)) {
                return false
            }
        }
        return true
    }

    fun part2(input: String): Int {
        val passports = input.trim().split("\n\n")
        return passports.filter(::isValid2).count()
    }

    private fun isValid2(passport: String): Boolean {
        requiredFields.forEach { field ->
            val key = field.first
            val valueCondition = field.second
            val matchResult = Regex("$key:(\\S+)[ ]*").find(passport) ?: return false
            val value = matchResult.groupValues[1].trim()
            if (!valueCondition.matches(value)) {
                return false
            }
        }
        return true
    }
}
