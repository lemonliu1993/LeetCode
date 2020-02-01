package com.lemon.leetcode.classify.binarysearchAndBST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode315
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * Created by lemoon on 20/2/1 下午6:19
 */
public class L5_Count_of_Smaller_Numbers_After_Self {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] reverse = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reverse[nums.length - i - 1] = nums[i];
        }

        BSTNode root = new BSTNode(reverse[0]);
        List<Integer> result = new ArrayList<>(nums.length);
        result.add(0);
        for (int i = 1; i < reverse.length; i++) {
            int val = root.insert(reverse[i],0);
            result.add(val);
        }
        Collections.reverse(result);
        return result;


    }


    class BSTNode {
        int val;
        int count;      //count的含义是记录二叉查找树左子树数量
        BSTNode left;
        BSTNode right;

        BSTNode(int val) {
            this.val = val;
        }

        int insert(int val, int countSmall) {
            int result = countSmall;
            if (val <= this.val) {
                this.count++;
                if (this.left == null) {
                    this.left = new BSTNode(val);
                    return result;
                }
                return this.left.insert(val, result);
            } else {
                result += this.count + 1;
                if (this.right == null) {
                    this.right = new BSTNode(val);
                    return result;
                }
                return this.right.insert(val,result);
            }

        }
    }


    //暴力，O(N^2)
    public List<Integer> countSmaller1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] a = new int[]{5, 2, 6, 1};
        int[] a = new int[]{5,-7,9,1,3,5,-2,1};
//        int[] a = new int[]{};
        L5_Count_of_Smaller_Numbers_After_Self demo = new L5_Count_of_Smaller_Numbers_After_Self();
        List<Integer> result = demo.countSmaller(a);
        System.out.println(result);
    }
}
