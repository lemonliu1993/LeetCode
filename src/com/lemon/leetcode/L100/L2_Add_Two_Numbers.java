package com.lemon.leetcode.L100;

/**
 * Created by lemoon on 19/12/21 上午8:13
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class L2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = new ListNode(0);
        ListNode node = result;
        int isUp = 0;
        while (l1 != null || l2 != null || isUp > 0) {
            int i1 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            int i2 = 0;
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }
            int sum = i1 + i2 + isUp;
            node.next = new ListNode(sum % 10);
            node = node.next;
            isUp = sum / 10;
        }
        return result.next;
    }
}
