package com.lemon.leetcode.classify.stackAndQueue;

import java.util.Stack;

/**
 * leetcode232
 * Created by lemoon on 20/1/22 上午9:02
 */
public class L2_Implement_Queue_using_Stacks {

    /**
     * Initialize your data structure here.
     */
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    /**
     * Initialize your data structure here.
     */
    public L2_Implement_Queue_using_Stacks() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
