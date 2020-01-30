package com.lemon.leetcode.classify.binarysearchAndBST;

import java.util.Arrays;

/**
 * leetcode34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * Created by lemoon on 20/1/30 下午5:34
 */
public class L2_Search_for_a_Range {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        result[0] = left;
        result[1] = right;
        return result;


    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                if (middle == 0 || nums[middle - 1] != target) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                if (middle == nums.length - 1 || nums[middle + 1] != target) {
                    return middle;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 7, 8, 8, 8, 8, 10};
        int[] ints = new L2_Search_for_a_Range().searchRange(a, 8);
        System.out.println(Arrays.toString(ints));
    }
}
