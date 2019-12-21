package com.lemon.leetcode.L100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lemoon on 19/12/21 上午8:53
 */
public class L3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                index = index > map.get(s.charAt(i))+1 ? index : map.get(s.charAt(i))+1;
            }
            len = len > i - index + 1 ? len : i - index + 1;
            map.put(s.charAt(i), i);
        }


        return len;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new L3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(s));
    }
}
