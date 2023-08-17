package com.example.string


import java.lang.StringBuilder

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

    fun reverseWords(s: String): String {
        val stringList = s.trim().split("\\s+".toRegex())
        val words = mutableListOf<String>()
        stringList.forEach {
            words.add(0, it)
        }
        return words.joinToString(" ")
    }

    fun reverseWords2(s: String): String {
        val words = mutableListOf<String>()
        s.reversed().split(" ")
            .forEach { word ->
                if (word.isNotBlank()) {
                    words.add(word.reversed())
                }
            }
        return words.joinToString(" ")
    }

    fun reverseLeftWords(s: String, n: Int): String {
        val sb = StringBuilder(s)
        sb.reverse(0, n - 1)
        sb.reverse(n, sb.length - 1)
        sb.reverse(0, sb.length - 1)
        return sb.toString()
    }

    private fun StringBuilder.reverse(left: Int, right: Int) {
        var start = left
        var end = right
        while (start < end) {
            val temp = this[start]
            this[start] = this[end]
            this[end] = temp
            start++
            end--
        }
    }

    fun reverseLeftWords2(s: String, n: Int): String {
        val len = s.length
        val sb = StringBuilder()
        s.forEachIndexed { index, c ->
            if (index + n < len) {
                sb.append(s[index + n])
            } else {
                sb.append(s[(index + n) % len])
            }
        }
        return sb.toString()
    }
}

fun main() {
    val solution = StringSolution()
    solution.replaceSpace("hello world")
}