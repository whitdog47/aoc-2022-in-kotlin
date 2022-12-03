class Day03 {

    private fun part1(input: List<String>) {
        var sum = 0
        input.forEach {
            val halfLength = it.length / 2
            val first = it.subSequence(0, halfLength)
            val second = it.substring(halfLength)
            var commonChar = ' '
            first.forEach { firstChar ->
                second.forEach { secondChar ->
                    if (firstChar == secondChar) {
                        commonChar = firstChar
                    }
                }
            }
            sum += if (commonChar in 'a'..'z') {
                commonChar.code - 96
            } else {
                commonChar.code - 38
            }
        }
        println(sum)
    }

    private fun part2(input: List<String>) {
        var sum = 0
        val memo = arrayOf("", "", "")
        var rowCount = 0
        input.forEach {
            if (rowCount < 3) {
                memo[rowCount] = it
                rowCount++
            }
            if (rowCount == 3) {
                rowCount = 0
                var commonChar = ' '
                memo[0].forEach { firstLine ->
                    memo[1].forEach { secondLine ->
                        memo[2].forEach { thirdLine ->
                            if (firstLine == secondLine && secondLine == thirdLine) {
                                commonChar = firstLine
                            }
                        }
                    }
                }
                sum += if (commonChar in 'a'..'z') {
                    commonChar.code - 96
                } else {
                    commonChar.code - 38
                }
            }
        }
        println(sum)
    }

    fun run() {
        val day = "Day03"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}