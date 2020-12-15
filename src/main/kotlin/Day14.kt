import utils.splitNewlines

object Day14 {

    fun part1(input: String): Long {
        var mask = ""
        val memory: MutableMap<Long, Long> = mutableMapOf()
        for (line in input.splitNewlines()) {
            line.parseMask { newMask ->
                mask = newMask
            }

            line.parseInstruction { address, value ->
                val newValue = mask.foldRightIndexed(value) { index, char, acc ->
                    val shift = mask.length - 1 - index
                    when (char) {
                        '1' -> acc.setBit(shift, true)
                        '0' -> acc.setBit(shift, false)
                        else -> acc
                    }
                }
                memory[address] = newValue
            }
        }
        return memory.values.sum()
    }

    private fun String.parseMask(block: (String) -> Unit) {
        val newMask = "mask = (.+)".toRegex().find(this)?.destructured
        if (newMask != null) {
            block.invoke(newMask.component1())
        }
    }

    private fun String.parseInstruction(block: (address: Long, value: Long) -> Unit) {
        val memoryAddress = "mem\\[(\\d+)] = (\\d+)".toRegex().find(this)
        if (memoryAddress != null) {
            val address = memoryAddress.groupValues[1].toLong()
            val value = memoryAddress.groupValues[2].toLong()
            block.invoke(address, value)
        }
    }

    private fun Long.setBit(index: Int, value: Boolean): Long {
        return if (value) {
            this or (1L shl index)
        } else {
            this and ((1L shl index).inv())
        }
    }

    fun part2(input: String): Long {
        var mask = ""
        val memory: MutableMap<Long, Long> = mutableMapOf()
        for (line in input.splitNewlines()) {
            line.parseMask { newMask ->
                mask = newMask
            }

            line.parseInstruction { baseAddress, value ->
                baseAddress.enumerateAddresses(mask).forEach {
                    memory[it] = value
                }
            }
        }
        return memory.values.sum()
    }

    private fun Long.enumerateAddresses(mask: String, index: Int = 0): MutableSet<Long> {
        val address = this
        if (index == mask.length) {
            return mutableSetOf(address)
        }

        return when (mask[mask.length - 1 - index]) {
            '0' -> address.enumerateAddresses(mask, index + 1)
            '1' -> address.setBit(index, true).enumerateAddresses(mask, index + 1)
            else -> mutableSetOf<Long>().apply {
                addAll(address.setBit(index, false).enumerateAddresses(mask, index + 1))
                addAll(address.setBit(index, true).enumerateAddresses(mask, index + 1))
            }
        }
    }
}
