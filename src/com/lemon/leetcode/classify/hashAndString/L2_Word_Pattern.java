package com.lemon.leetcode.classify.hashAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode290
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母
 * Created by lemoon on 20/2/2 下午8:32
 */
public class L2_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] strList = str.split(" ");
        if (strList.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strList[i])) {     //不能用!=  要用equals
                    return false;
                }
            } else {
                if (map.containsValue(strList[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), strList[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L2_Word_Pattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new L2_Word_Pattern().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new L2_Word_Pattern().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new L2_Word_Pattern().wordPattern("abba", "dog dog dog dog"));
    }
}
