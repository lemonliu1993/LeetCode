package com.lemon.leetcode.classify.linkedlist;

/**
 * leetcode86
 * Created by lemoon on 20/1/11 上午10:22
 */
public class L6_Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode bigger = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode biggerNode = bigger;
        ListNode smallerNode = smaller;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                smallerNode.next = node;
                smallerNode = smallerNode.next;
                smallerNode.next = null;
            } else {
                biggerNode.next = node;
                biggerNode = biggerNode.next;
                biggerNode.next = null;
            }
            node = next;
        }
        smallerNode.next = bigger.next;
        return smaller.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
