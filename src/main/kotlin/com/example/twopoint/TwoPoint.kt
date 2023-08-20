package com.example.twopoint

class TwoPoint {
    /**
     * 原地移除[nums]中所有值为[value]
     *
     */
    fun removeElement(nums: IntArray, value: Int): Int {
        var slow = 0
        nums.forEach { num ->
            if (num != value) {
                nums[slow] = num
                slow++
            }
        }
        return slow
    }
}