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

/**
 * Wiggle max length
 *如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * @param nums
 * @return
 */
fun wiggleMaxLength(nums: IntArray): Int {
    if (nums.size <= 1) {
        return nums.size
    }
    var ans = 1
    var currDiff = 0
    var preDiff = 0
    for (i in 0 until nums.size - 1) {
        currDiff = nums[i + 1] - nums[i]
        if (preDiff <= 0 && currDiff > 0 || (preDiff >= 0 && currDiff < 0)) {
            preDiff = currDiff
            ans++
        }
    }
    return ans
}

/**
 * 详情:
 * [最大子数组和](https://programmercarl.com/0053.%E6%9C%80%E5%A4%A7%E5%AD%90%E5%BA%8F%E5%92%8C.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE)
 */
fun maxSubArray(nums: IntArray): Int {
    var ans = Int.MIN_VALUE
    var count = 0
    nums.forEach { num ->
        count += num
        if (count > ans) {
            ans = count
        }
        if (count < 0) {
            count = 0
        }
    }
    return ans
}
