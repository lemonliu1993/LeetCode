package com.lemon.leetcode.classify.linkedlist;

import java.util.List;

/**
 * Created by lemoon on 20/1/11 上午9:25
 */

public class L1_Reverse_Linked_List {

    //头指针正向遍历
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode temp = result.next;
            ListNode next = head.next;
            result.next = head;
            head.next = temp;
            head = next;
        }
        return result.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
