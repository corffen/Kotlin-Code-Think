package com.example.greedy

fun findContentChildren(g: IntArray, s: IntArray): Int {
    var gi = 0
    var sj = 0
    val glen = g.size
    val slen = s.size
    var count = 0
    g.sort()
    s.sort()
    while (gi < glen && sj < slen) {
        while (sj < slen && s[sj] < g[gi]) {
            sj++
        }
        if (sj < slen) {
            count++
        }
        sj++
        gi++
    }
    return count
}
