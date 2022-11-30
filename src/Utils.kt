import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name/main.txt").readLines()
fun readTestInput(name: String) = File("src", "$name/test.txt").readLines()

fun readInputAsInt(name: String) = File("src", "$name/main.txt").readLines().map { it.toInt() }
fun readTestInputAsInt(name: String) = File("src", "$name/test.txt").readLines().map { it.toInt() }

private fun fileToPairStringInt(name: String, ext: String) = File("src", "$name/$ext.txt").readLines().map {
    val (s, i) = it.split(" ")
    s to i.toInt()
}
fun readInputStringToInt(name: String) = fileToPairStringInt(name, "main")
fun readTestInputStringToInt(name: String) = fileToPairStringInt(name, "test")

private fun fileToTripleStringIntInt(name: String, ext: String) = File("src", "$name/$ext.txt").readLines().map {
    val (s, i, i2) = it.split(" ")
    Triple(s,i.toInt(),i2.toInt())
}
fun readInputStringToIntToInt(name: String) = fileToTripleStringIntInt(name, "main")
fun readTestInputStringToIntToInt(name: String) = fileToTripleStringIntInt(name, "test")

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
fun manDistance(x1:Int, y1:Int, x2:Int, y2:Int) : Int {
    return  kotlin.math.abs(x1 - x2) + kotlin.math.abs(y1 - y2)
}
fun manDistance(v1: Triple<Int, Int, Int>, v2: Triple<Int, Int, Int>) : Int {
    return  kotlin.math.abs(v1.first - v2.first) + kotlin.math.abs(v1.second - v2.second) + kotlin.math.abs(v1.third -v2.third)
}

fun String.moveCharAt(from: Int, to: Int): String {
    val c = this[from]
    val s = this.substring(0, from) + this.substring(from + 1)
    return if (to > 0) {
        if (to >= s.length) {
            s.substring(0, to) + c
        } else {
            s.substring(0, to) + c + s.substring(to + 1)
        }
    } else c + s
}
