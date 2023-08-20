package com.example.twopoint

import com.example.ListNode

class TwoPointSolution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var tmpA = headA
        var tmpB = headB
        var lenA = 0
        var lenB = 0
        while (tmpA != null) {
            tmpA = tmpA.next
            lenA++
        }
        while (tmpB != null) {
            tmpB = tmpB.next
            lenB++
        }
        tmpA = headA
        tmpB = headB
        val gap = lenA - lenB
        if (gap < 0) {
            return getIntersectionNode(headB, headA)
        }
        while (gap > 0) {
            tmpA = tmpA?.next
        }
        while (tmpA != null) {
            if (tmpB == tmpA) {
                return tmpB
            }
            tmpB = tmpB?.next
            tmpA = tmpA.next
        }

        return tmpB
    }
}