class Day11 {

    private fun part1Test(input: List<String>) {
        val monkey = mapOf(0 to mutableListOf(79L,98L), 1 to mutableListOf(54L,65L,75L,74L), 2 to mutableListOf(79L,60L,97L), 3 to mutableListOf(74L))

        val inspect = arrayListOf(0,0,0,0,0,0,0,0)
        repeat(1000) {r ->
            (0..3).forEach { i ->
                monkey[i]!!.forEach {

                    var w = when (i) {
                        0 -> it * 19
                        1 -> it + 6
                        2 -> it * it
                        3 -> it + 3

                        else -> it
                    }
//                    println(w)
//                    w = w.div(3)
//                    println(w)
                    val test = when (i) {
                        0 -> w % 23L == 0L
                        1 -> w % 19L== 0L
                        2 -> w % 13L == 0L
                        3 -> w % 17L == 0L

                        else -> false
                    }
                    val newm = when (i) {
                        0 -> if (test) 2 else 3
                        1 -> if (test) 2 else 0
                        2 -> if (test) 1 else 3
                        3 -> if (test) 0 else 1

                        else -> false
                    }
//                    println(newm)
                    monkey[newm]!!.add(w)
//                    println(monkey[newm])
                    inspect[i]++
                }
                monkey[i]!!.clear()
            }
            println(monkey)
            if (1==1 || (r+1) % 1000 == 0) {
                 println("${(r+1)} $inspect")
            }
        }
        inspect.sortDescending()
        val a = inspect.take(2)
        println(a[0].toLong()*a[1].toLong())
    }
    private fun part1(input: List<String>) {
        val monkey = mapOf(0 to mutableListOf(74L, 73L, 57L, 77L, 74L), 1 to mutableListOf(99L, 77L, 79L), 2 to mutableListOf(64L, 67L, 50L, 96L, 89L, 82L, 82L),
                3 to mutableListOf(88L), 4 to mutableListOf(80L, 66L, 98L, 83L, 70L, 63L, 57L, 66L), 5 to mutableListOf(81L, 93L, 90L, 61L, 62L, 64L),
                6 to mutableListOf(69L, 97L, 88L, 93L), 7 to mutableListOf(59L, 80L))

        val inspect = arrayListOf(0,0,0,0,0,0,0,0)
        repeat(20) {
            (0..7).forEach { i ->
                monkey[i]!!.forEach {

                    var w = when (i) {
                        0 -> it * 11
                        1 -> it + 8
                        2 -> it + 1
                        3 -> it * 7
                        4 -> it + 4
                        5 -> it + 7
                        6 -> it * it
                        7 -> it + 6
                        else -> it
                    }
                    w = w.div(3)
                    val test = when (i) {
                        0 -> w % 19L == 0L
                        1 -> w % 2L == 0L
                        2 -> w % 3L == 0L
                        3 -> w % 17L == 0L
                        4 -> w % 13L == 0L
                        5 -> w % 7L == 0L
                        6 -> w % 5L == 0L
                        7 -> w % 11L == 0L
                        else -> false
                    }
                    val newm = when (i) {
                        0 -> if (test) 6 else 7
                        1 -> if (test) 6 else 0
                        2 -> if (test) 5 else 3
                        3 -> if (test) 5 else 4
                        4 -> if (test) 0 else 1
                        5 -> if (test) 1 else 4
                        6 -> if (test) 7 else 2
                        7 -> if (test) 2 else 3
                        else -> false
                    }
                    monkey[newm]!!.add(w)
                    inspect[i]++
                }
                monkey[i]!!.clear()
            }
        }
        inspect.sortDescending()
        val a = inspect.take(2)
        println(a[0]*a[1])
    }

    private fun part2(input: List<String>) {
        val monkey = mapOf(0 to mutableListOf(74L, 73L, 57L, 77L, 74L), 1 to mutableListOf(99L, 77L, 79L), 2 to mutableListOf(64L, 67L, 50L, 96L, 89L, 82L, 82L),
                3 to mutableListOf(88L), 4 to mutableListOf(80L, 66L, 98L, 83L, 70L, 63L, 57L, 66L), 5 to mutableListOf(81L, 93L, 90L, 61L, 62L, 64L),
                6 to mutableListOf(69L, 97L, 88L, 93L), 7 to mutableListOf(59L, 80L))

        val lcm = 19L*2L*3L*17L*13L*7L*5L*11L
        val inspect = arrayListOf(0,0,0,0,0,0,0,0)
        repeat(10000) {
            (0..7).forEach { i ->
                monkey[i]!!.forEach {

                    var w = when (i) {
                        0 -> it * 11
                        1 -> it + 8
                        2 -> it + 1
                        3 -> it * 7
                        4 -> it + 4
                        5 -> it + 7
                        6 -> it * it
                        7 -> it + 6
                        else -> it
                    }
                    val test = when (i) {
                        0 -> w % 19L == 0L
                        1 -> w % 2L == 0L
                        2 -> w % 3L == 0L
                        3 -> w % 17L == 0L
                        4 -> w % 13L == 0L
                        5 -> w % 7L == 0L
                        6 -> w % 5L == 0L
                        7 -> w % 11L == 0L
                        else -> false
                    }
                    val newm = when (i) {
                        0 -> if (test) 6 else 7
                        1 -> if (test) 6 else 0
                        2 -> if (test) 5 else 3
                        3 -> if (test) 5 else 4
                        4 -> if (test) 0 else 1
                        5 -> if (test) 1 else 4
                        6 -> if (test) 7 else 2
                        7 -> if (test) 2 else 3
                        else -> false
                    }
                    w %= lcm
                    monkey[newm]!!.add(w)
                    inspect[i]++
                }
                monkey[i]!!.clear()
            }
        }
        inspect.sortDescending()
        val a =inspect.take(2)
        println(a[0].toLong()*a[1].toLong())
    }

    fun run() {
        val day = "Day11"

        val input = readInput(day)
        part1(input)
//        part1Test(input)
        part2(input)
    }
}


