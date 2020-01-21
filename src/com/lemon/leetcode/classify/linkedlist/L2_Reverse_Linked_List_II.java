package com.lemon.leetcode.classify.linkedlist;

/**
 * leetcode092
 * Created by lemoon on 20/1/11 上午9:25
 */
public class L2_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode preM = null;
        ListNode afterTail = null;
        ListNode newHead = null;
        int len = n - m;
        if (m == 1 && n == 1) {
            return head;
        }
        if (m == 1) {
            //preM 为空
            preM = null;
            afterTail = head;
        } else {
            while (m > 2) {
                node = node.next;
                m--;
            }
            preM = node;
            afterTail = node.next;
            node = node.next;
        }
        ListNode headPoint = new ListNode(0);
        while (len >= 0) {
            ListNode next = headPoint.next;
            ListNode newNode = node.next;
            headPoint.next = node;
            node.next = next;
            node = newNode;
            len--;
        }
        if (preM != null) {
            preM.next = headPoint.next;
            afterTail.next = node;
            return head;
        } else {
            afterTail.next = node;
            return headPoint.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = new L2_Reverse_Linked_List_II().reverseBetween(a, 2, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
