package com.lemon.leetcode.classify.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode141
 * Created by lemoon on 20/1/11 上午10:20
 */
public class L4_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
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
