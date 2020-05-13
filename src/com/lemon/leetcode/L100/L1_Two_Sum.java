package com.lemon.leetcode.L100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lemoon on 19/12/20 下午11:14
 * note:求数组中两个数和为固定数字的方法：
 * 一次遍历，使用map保存之前出现过的数的位置，到当前位置时找之前是否出现过该数。
 */
public class L1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
