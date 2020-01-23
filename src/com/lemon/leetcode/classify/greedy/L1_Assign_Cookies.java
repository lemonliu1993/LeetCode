package com.lemon.leetcode.classify.greedy;

import java.util.Arrays;

/**
 * leetcode455
 * Created by lemoon on 20/1/23 上午8:57
 */
public class L1_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            throw new RuntimeException();
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && s[i] >= g[index]) {
                index++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        System.out.println(new L1_Assign_Cookies().findContentChildren(g, s));
    }
}
