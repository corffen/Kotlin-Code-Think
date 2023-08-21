package com.example.twopoint

import com.example.ListNode
import java.util.Arrays

class TwoPointSolution {
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

    fun reverseString(s: CharArray): Unit {
        s.reverse()
    }

    fun reverseString2(s: CharArray): Unit {
        var l = 0
        var r = s.lastIndex
        while (l < r) {
            val tmp = s[l]
            s[l] = s[r]
            s[r] = tmp
            l++
            r--
        }
    }

    fun reverseString3(s: CharArray): Unit {
        val mid = s.size / 2 - 1
        if (mid < 0) {
            return
        }
        var r = s.lastIndex
        for (index in 0..mid) {
            val tmp = s[index]
            s[index] = s[r]
            s[r] = tmp
            r--
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var curr = head
        while (curr != null) {
            val tmp = curr.next
            curr.next = pre
            pre = curr
            curr = tmp
        }
        return pre
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast: ListNode? = head
        var slow: ListNode? = ListNode(0).apply { next = head }
        var k = n
        while (k > 0 && fast != null) {
            fast = fast.next
            k--
        }
        while (fast != null) {
            fast = fast.next
            slow = slow!!.next
        }
        slow!!.next = slow.next!!.next
        return slow
    }

    fun detectCycle(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                var step1 = fast
                var step2 = head
                while (step1 != step2) {
                    step1 = step1?.next
                    step2 = step2?.next
                }
                return step1
            }
        }
        return null
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        Arrays.sort(nums)
        for (i in 0 until nums.size) {
            if (nums[i] > 0) {
                return result
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]
                if (sum > 0) {
                    right--
                } else if (sum < 0) {
                    left++
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }
                    left++
                    right--
                }
            }
        }
        return result
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        Arrays.sort(nums)
        for (i in 0 until nums.size) {
            if (nums[i] > 0&&nums[i]>target) {
                return result
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            for (j in i + 1 until nums.size) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue
                }
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = nums[left] + nums[right] + nums[i]+nums[j]
                    if (sum > target) {
                        right--
                    } else if (sum < target) {
                        left++
                    } else {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }
                        left++
                        right--
                    }
                }
            }
        }
        return result
    }
}