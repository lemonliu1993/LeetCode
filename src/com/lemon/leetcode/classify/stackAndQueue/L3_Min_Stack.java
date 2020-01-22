package com.lemon.leetcode.classify.stackAndQueue;

import java.util.Stack;

/**
 * leetcode155
 * Created by lemoon on 20/1/22 上午11:51
 */
public class L3_Min_Stack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            minStack.push(x);
        }else{
            stack.push(x);
            if(x>minStack.peek()){
                minStack.push(minStack.peek());
            }else{
                minStack.push(x);
            }
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
