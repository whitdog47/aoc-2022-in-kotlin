class Day05 {

    private fun part1(input: List<String>, start: List<String>) {
        val crates = mutableMapOf(1 to "TPZCSLQN", 2 to "LPTVHCG", 3 to "DCZF", 4 to "GWTDLMVC", 5 to "PWC", 6 to "PFJDCTSZ", 7 to "VWGBD", 8 to "NJSQHW", 9 to "RCQFSLV")
        input.forEach {
            val line = it.split(" ")
            val moveCount = line[1].toInt()
            val from = line[3].toInt()
            val to = line[5].toInt()
            repeat(moveCount) {
                val fromBucket = (crates[from] ?:"")
                val fromChar = fromBucket.last()
                crates[to] = (crates[to] ?: "") + fromChar
                crates[from] = fromBucket.substring(0, fromBucket.length-1)
            }
        }
        println(crates.values.map { it.last() }.joinToString(""))
    }

    private fun part2(input: List<String>) {
        val crates = mutableMapOf(1 to "TPZCSLQN", 2 to "LPTVHCG", 3 to "DCZF", 4 to "GWTDLMVC", 5 to "PWC", 6 to "PFJDCTSZ", 7 to "VWGBD", 8 to "NJSQHW", 9 to "RCQFSLV")
        input.forEach {
            val line = it.split(" ")
            val moveCount = line[1].toInt()
            val from = line[3].toInt()
            val to = line[5].toInt()

            val fromBucket = (crates[from] ?:"")
            val fromCrates = fromBucket.substring(fromBucket.length-moveCount, fromBucket.length)
            crates[to] = (crates[to] ?: "") + fromCrates
            crates[from] = fromBucket.substring(0, fromBucket.length-moveCount)

        }
        println(crates.values.map { it.last() }.joinToString(""))
    }

    fun run() {
        val day = "Day05"

        val input = readInput(day)
        val input2 = readTestInput(day)
        part1(input, input2)
        part2(input)
    }
}
