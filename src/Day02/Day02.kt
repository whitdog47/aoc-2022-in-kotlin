class Day02 {

    private fun part1(input: List<String>) {
        var score = 0
        input.forEach {
            score += when (it[0]) {
                'A' -> when (it[2]) {
                    'X' -> 1+3
                    'Y' -> 2+6
                    'Z' -> 3+0
                    else -> 0
                }
                'B' -> when (it[2]) {
                    'X' -> 1+0
                    'Y' -> 2+3
                    'Z' -> 3+6
                    else -> 0
                }
                'C' -> when (it[2]) {
                    'X' -> 1+6
                    'Y' -> 2+0
                    'Z' -> 3+3
                    else -> 0
                }
                else -> 0
            }
        }
        println(score)
    }

    private fun part2(input: List<String>) {
        var score = 0
        input.forEach {
            score += when (it[0]) {
                'A' -> when (it[2]) {
                    'X' -> 3 //lose
                    'Y' -> 4 // draw
                    'Z' -> 8 // win
                    else -> 0
                }
                'B' -> when (it[2]) {
                    'X' -> 1
                    'Y' -> 5
                    'Z' -> 9
                    else -> 0
                }
                'C' -> when (it[2]) {
                    'X' -> 2
                    'Y' -> 6
                    'Z' -> 7
                    else -> 0
                }
                else -> 0
            }
        }
        println(score)
    }

    fun run() {
        val day = "Day02"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
