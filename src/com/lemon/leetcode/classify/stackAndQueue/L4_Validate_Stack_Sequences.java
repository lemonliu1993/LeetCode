package com.lemon.leetcode.classify.stackAndQueue;

import java.util.Stack;

/**
 * leetcode946
 * Created by lemoon on 20/1/22 下午3:43
 */
public class L4_Validate_Stack_Sequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[index]==stack.peek()){
                stack.pop();
                index++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] poped = new int[]{4, 5, 3, 2, 1};
        int[] poped = new int[]{4, 3, 5, 1, 2};
        System.out.println(new L4_Validate_Stack_Sequences().validateStackSequences(pushed, poped));
    }
}
