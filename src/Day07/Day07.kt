class Day07 {

    private data class Directory(val name: String, val files: MutableMap<String,Int>, val dirs: MutableList<Directory>, val previous: Directory?, var size: Long)
    private fun part1(input: List<String>) {
        val alldirs = mutableListOf<Directory>()
        var curr = Directory("/", mutableMapOf(), mutableListOf(), null, 0L)
        val main = curr
        alldirs.add(curr)
        input.forEach {
            val cmds = it.split(" ")
            when (cmds[0]) {
                "$" -> {
                    when (cmds[1]) {
                        "cd" -> {
                            if (cmds[2] == "..") {
                                curr = curr.previous!!
                            } else if (cmds[2] == "/") {
                                // so slash
                                curr = main
                            } else {

                                curr.dirs.forEach {
                                    if (it.name == cmds[2]) {
                                        curr = it
                                        return@forEach
                                    }
                                }
                            }
                        }
                        "ls" -> {

                        }
                    }
                }
                "dir" -> {
                    if (!curr.dirs.any { dir -> dir.name == cmds[1] }) {
                        val newdir = Directory(cmds[1], mutableMapOf(), mutableListOf(), curr, 0L)
                        curr.dirs.add(newdir)
                        alldirs.add(newdir)
                    }
                }
                else -> {
                    //number so a file
                    curr.files[cmds[1]] = cmds[0].toInt()
                }
            }
        }
        println(findSize(main))
//        sumT = 0L
//        println(sumT)
    }
//21309880
    //8690120
    private var min = 8690120
    private val mins = mutableListOf<Long>()
    private var sumT = 0L
    private fun findSize(start: Directory) : Long {
        var size = start.files.values.sum().toLong()
        start.dirs.forEach {
            size += findSize(it)
        }
        if (size <= 100000) {
            sumT+= size
        }
        if (size > min) {
            mins += size
            mins.sort()
            println(mins.first())
        }

        return size
    }

    private fun part2(input: List<String>) {

    }

    fun run() {
        val day = "Day07"

        val input = readInput(day)
        part1(input)
        part2(input)
    }
}
