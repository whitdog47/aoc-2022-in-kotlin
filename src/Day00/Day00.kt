package Day00

import readInput
import readTestInput

class Day00 {

    private fun part1(input: List<String>): Int {
        return input.size
    }

    private fun part2(input: List<String>): Int {
        return input.size
    }

    fun run() {
        val testInput1 = readTestInput("Day00")
        check(part1(testInput1) == 0)
        println(part1(testInput1))

        //val input1 = readInput("Day00")
        //check(part1(input1) == 1)
        //println(part1(input1))

//        val testInput2 = readTestInput("Day00")
//        check(part2(testInput2) == 0)
//        println(part2(testInput2))

        //val input2 = readInput("Day00")
        //check(part2(input2) == 1)
        //println(part2(input2))
    }
}
