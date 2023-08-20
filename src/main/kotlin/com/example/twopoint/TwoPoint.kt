package com.example.twopoint

import com.example.ListNode

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
}