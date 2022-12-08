class Day08 {

    private fun part1(input: List<String>) {
        val max = 98
        val grid = Array(max + 1) { IntArray(max + 1) }
        var row = 0
        input.forEach {
            var col = 0
            it.forEach { c ->
                grid[row][col] = c.digitToInt()
                col++
            }
            row++
        }
        var count = (max + 1) * 2 + (max - 1) * 2

        (0..max).forEach { r ->
            (0..max).forEach { c ->
                if (r == 0 || r == max || c == 0 || c == max) {

                } else {
                    var vis = 0
                    (0..r - 1).forEach { rr ->
                        if (grid[rr][c] >= grid[r][c]) {
                            vis++
                        }
                    }
                    if (vis == 0) {
                        count++
                    } else {
                        vis = 0
                        (r + 1..max).forEach { rr ->
                            if (grid[rr][c] >= grid[r][c]) {
                                vis++
                            }
                        }

                        if (vis == 0) {
                            count++
                        } else {
                            vis = 0
                            (0..c - 1).forEach { cc ->
                                if (grid[r][cc] >= grid[r][c]) {
                                    vis++
                                }
                            }

                            if (vis == 0) {
                                count++
                            } else {
                                vis = 0
                                (c + 1..max).forEach { cc ->
                                    if (grid[r][cc] >= grid[r][c]) {
                                        vis++
                                    }
                                }
                                if (vis == 0) {
                                    count++
                                }
                            }
                        }
                    }
                }
            }
        }
        println(count)
    }

    private fun part2(input: List<String>) {
        val max = 98
        val grid = Array(max + 1) { IntArray(max + 1) }
        var row = 0
        input.forEach {
            var col = 0
            it.forEach { c ->
                grid[row][col] = c.digitToInt()
                col++
            }
            row++
        }
        var count = (max + 1) * 2 + (max - 1) * 2

        var maxScore = 0
        (0..max).forEach { r ->
            (0..max).forEach { c ->
                var score = 0
                var vis = 0
                var stop = false
                if (r == 0 || r == max || c == 0 || c == max) {
                } else {
                    vis = 0
                    stop = false
                    (r - 1 downTo 0).forEach { rr ->
                        if (!stop && grid[rr][c] < grid[r][c]) {
                            vis++
                        } else if (!stop && grid[rr][c] >= grid[r][c]) {
                            vis++
                            stop = true
                        } else {
                            stop = true
                        }
                    }
                    score = vis

                    vis = 0
                    stop = false
                    (r + 1..max).forEach { rr ->
                        if (!stop && grid[rr][c] < grid[r][c]) {
                            vis++
                        } else if (!stop && grid[rr][c] >= grid[r][c]) {
                            vis++
                            stop = true
                        } else {
                            stop = true
                        }
                    }
                    score *= vis

                    vis = 0
                    stop = false
                    (c - 1 downTo 0).forEach { cc ->
                        if (!stop && grid[r][cc] < grid[r][c]) {
                            vis++
                        } else if (!stop && grid[r][cc] >= grid[r][c]) {
                            vis++
                            stop = true
                        } else {
                            stop = true
                        }
                    }
                    score *= vis


                    vis = 0
                    stop = false
                    (c + 1..max).forEach { cc ->
                        if (!stop && grid[r][cc] < grid[r][c]) {
                            vis++
                            if (r==1 && c == 2) {
                            }
                        } else if (!stop && grid[r][cc] >= grid[r][c]) {
                            vis++
                            stop = true
                        } else {
                            stop = true
                        }
                    }

                    score *= vis

                }
                if (score > maxScore) {
                    maxScore = score
                }
            }
        }
        println(maxScore)
    }

    fun run() {
        val day = "Day08"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
