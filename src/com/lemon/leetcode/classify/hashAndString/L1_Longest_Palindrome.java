package com.lemon.leetcode.classify.hashAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode409
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * Created by lemoon on 20/2/2 下午5:58
 */
public class L1_Longest_Palindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        boolean flag = false;
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                flag = true;
                result += entry.getValue() - 1;
            } else {
                result += entry.getValue();
            }
        }
        if (flag) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L1_Longest_Palindrome().longestPalindrome("abccccdd"));
    }
}
