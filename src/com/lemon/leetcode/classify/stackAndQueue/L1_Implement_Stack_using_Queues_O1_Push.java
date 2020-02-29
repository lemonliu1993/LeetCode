package com.lemon.leetcode.classify.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode225
 * Created by lemoon on 20/1/22 上午9:01
 */
public class L1_Implement_Stack_using_Queues_O1_Push {
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    private int top;

    public L1_Implement_Stack_using_Queues_O1_Push() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.peek();
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        Queue<Integer> temp = new LinkedList<>();
        queue1 = queue2;
        queue2 = temp;
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        L1_Implement_Stack_using_Queues_O1_Push stack = new L1_Implement_Stack_using_Queues_O1_Push();
        stack.push(1);
        stack.pop();
        System.out.println(stack.empty());
    }
}
