class Day01 {

    private fun part1(input: List<String>) {
        var max = 0
        var group = 0
        input.forEach{
            if (it.isBlank()) {
                if (group > max) {
                    max = group
                }
                group = 0
            } else {
                group += it.toInt()
            }
        }

        println(max)
    }

    private fun part2(input: List<String>) {
        val max = mutableListOf<Int>()
        var group = 0
        input.forEach{
            if (it.isBlank()) {
                max.add(group)
                group = 0
            } else {
                group += it.toInt()
            }
        }

        max.sort()
        println(max.takeLast(3).sum())
    }

    fun run() {
        val day = "Day01"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
