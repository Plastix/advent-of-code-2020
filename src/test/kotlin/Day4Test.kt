import junit.framework.TestCase.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day4Test {

    companion object {
        private val INPUT by lazy {
            getResourceAsString("day4.txt")
        }

        private val SAMPLE = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
            
            iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
            hcl:#cfa07d byr:1929
            
            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm
            
            hcl:#cfa07d eyr:2025 pid:166559648
            iyr:2011 ecl:brn hgt:59in
        """.trimIndent()
    }

    @Test
    fun `part 1 samples`() {
        assertEquals(2, Day4.part1(SAMPLE))
    }

    @Test
    fun `part 1`() {
        assertEquals(239, Day4.part1(INPUT))
    }
    
    @Test
    fun `part 2`() {
        assertEquals(188, Day4.part2(INPUT))
    }
}
