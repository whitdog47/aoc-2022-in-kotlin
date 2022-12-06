class Day06 {

    private fun part1(input: List<String>) {
        val d = input[0]
        (0..d.length).forEach {
            val sub = d.substring(it, it + 4)
            if (sub[0] != sub[1] && sub[1] != sub[2] && sub[1] != sub[3]&& sub[2] != sub[3]&& sub[0] != sub[2]&& sub[0] != sub[3]) {
                println(it+4)
                return
            }
        }

    }

    private fun part2(input: List<String>) {
        val d = input[0]
        (0..d.length).forEach {v ->
            val dd = mutableSetOf<Char>()
            var ee = 0
            repeat(14) {
                dd.add(d[v+ee])
                ee++
            }
            if (dd.size == 14) {
                println(v+14)
                return
            }
        }
    }

    fun run() {
        val day = "Day06"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
