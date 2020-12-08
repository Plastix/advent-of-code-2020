import utils.splitNewlines

typealias Instruction = Pair<String, Int>

object Day8 {

    private const val NOP = "nop"
    private const val JUMP = "jmp"
    private const val INCREMENT = "acc"

    fun part1(input: String): Int {
        val instructions = input.splitNewlines().map(this::parseInstruction)
        return executeProgram(instructions).first
    }

    fun part2(input: String): Int {
        val instructions = input.splitNewlines().map(this::parseInstruction)

        val flipIndexes = instructions.mapIndexedNotNull { index, instruction ->
            index.takeIf { instruction.first == NOP || instruction.first == JUMP }
        }

        flipIndexes.forEach { index ->
            val program = flipInstructionAtIndex(instructions, index)
            val (acc, halted) = executeProgram(program)
            if (halted) {
                return acc
            }
        }

        return -1
    }

    private fun flipInstructionAtIndex(instructions: List<Instruction>, flipIndex: Int): List<Instruction> {
        return instructions.mapIndexed { index, instruction ->
            if (flipIndex == index) {
                val (opcode, immediate) = instruction
                when (opcode) {
                    JUMP -> NOP to immediate
                    NOP -> JUMP to immediate
                    else -> instruction
                }
            } else {
                instruction
            }
        }
    }

    private fun executeProgram(instructions: List<Instruction>): Pair<Int, Boolean> {
        val executedInstructions: MutableSet<Int> = mutableSetOf()
        var acc = 0
        var programCounter = 0

        while (programCounter < instructions.size) {
            if (executedInstructions.contains(programCounter)) {
                break // Infinite loop found
            }

            executedInstructions.add(programCounter)
            val instruction = instructions[programCounter]
            when (instruction.first) {
                NOP -> programCounter++
                INCREMENT -> {
                    acc += instruction.second
                    programCounter++
                }
                JUMP -> programCounter += instruction.second
            }
        }

        return acc to (programCounter == instructions.size)
    }

    private fun parseInstruction(line: String): Instruction {
        val (opcode, immediate) = "(...) (.\\d+)".toRegex().matchEntire(line)!!.destructured
        return opcode to immediate.toInt()
    }
}
