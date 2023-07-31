package com.example.string

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


}