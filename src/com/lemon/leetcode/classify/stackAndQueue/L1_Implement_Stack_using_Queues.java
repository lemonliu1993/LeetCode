package com.lemon.leetcode.classify.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode225
 * Created by lemoon on 20/1/22 上午9:01
 */
public class L1_Implement_Stack_using_Queues {
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public L1_Implement_Stack_using_Queues() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            return;
        } else {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
    }

    public void push1(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            return;
        } else {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }

            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        L1_Implement_Stack_using_Queues stack = new L1_Implement_Stack_using_Queues();
        stack.push(1);
        stack.pop();
        System.out.println(stack.empty());
    }
}
