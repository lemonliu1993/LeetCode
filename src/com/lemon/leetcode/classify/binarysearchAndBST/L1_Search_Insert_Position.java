package com.lemon.leetcode.classify.binarysearchAndBST;

/**
 * leetcode35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * Created by lemoon on 20/1/30 下午4:55
 */
public class L1_Search_Insert_Position {

    //beat 100% 时间  100% 空间
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException();
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        int index = -1;
        while (index == -1) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                if (middle == 0 || nums[middle - 1] < target) {
                    index = middle;
                } else {
                    right = middle - 1;
                }
            } else {
                if (middle == nums.length - 1 || nums[middle + 1] > target) {
                    index = middle + 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return index;
    }

    public int searchInsert1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }


}
