package com.lemon.leetcode.classify.linkedlist;

/**
 * leetcode160
 * Created by lemoon on 20/1/11 上午9:26
 */
public class L3_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int dis = 0;
        if (lenA > lenB) {
            dis = lenA - lenB;
            while (dis > 0) {
                headA = headA.next;
                dis--;
            }
        } else {
            dis = lenB - lenA;
            while (dis > 0) {
                headB = headB.next;
                dis--;
            }
        }

        while (headA != headB && headA != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode head) {
        int result = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            result++;
        }
        return result;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
