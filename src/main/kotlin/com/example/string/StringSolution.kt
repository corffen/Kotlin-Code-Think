package com.example.string


import java.lang.StringBuilder
import kotlin.math.min

class StringSolution {

    fun reverseString(s: CharArray): Unit {
        s.reverse()
    }

    fun reverseStr(s: String, k: Int): String {
        val n = s.length
        val chars = s.toCharArray()
        var i = 0
        while (i < n) {
            reverse(chars, i, min(n, i + k) - 1)
            i += 2 * k
        }
        return String(chars)
    }

    private fun reverse(arr: CharArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            left++
            right--
        }
    }

    fun replaceSpace(s: String): String {
        return s.replace(" ", "%20")
    }

    fun replaceSpace2(s: String): String {
        val sb = StringBuilder()
        s.forEach {
            if (it == ' ') {
                sb.append("%20")
            } else {
                sb.append(it)
            }
        }
        return sb.toString()
    }

}

fun main() {
    val solution = StringSolution()
    solution.replaceSpace("hello world")
}