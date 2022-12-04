class Day04 {

    private fun part1(input: List<String>) {
        var s = 0
        input.forEach {
            val z = it.split(",")
            val a = z[0].split("-")
            val b = z[1].split("-")

            if (b[0].toInt() >= a[0].toInt() && a[1].toInt() >= b[1].toInt()) {
                s++
            } else if (b[0].toInt() <= a[0].toInt() && a[1].toInt() <= b[1].toInt()) {
                s++
            }
        }
        println(s)
    }

    private fun part2(input: List<String>) {
        var s = 0
        input.forEach { it ->
            val r = it.split(",")
            val r1 = r[0].split("-").map { it.toInt() }
            val r2 = r[1].split("-").map { it.toInt() }
            val p1 = (r1[0]..r1[1])
            val p2 = (r2[0]..r2[1])
            if (p1.intersect(p2).isNotEmpty()) {
                s++
            }
        }
        println(s)
    }

    fun run() {
        val day = "Day04"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
//563
