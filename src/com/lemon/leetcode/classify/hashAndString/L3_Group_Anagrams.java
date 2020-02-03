package com.lemon.leetcode.classify.hashAndString;

import java.util.*;

/**
 * leetcode49
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * Created by lemoon on 20/2/2 下午9:34
 */
public class L3_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strSort(strs[i]);
            List<String> list;
            if (map.containsKey(s)) {
                list = map.get(s);
                list.add(strs[i]);

            } else {
                list = new ArrayList<>();
                list.add(strs[i]);
            }
            map.put(s, list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String strSort(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(str.length());
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        sb.append(charArray);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L3_Group_Anagrams().strSort("avds"));
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new L3_Group_Anagrams().groupAnagrams(strs);
        System.out.println(lists);
    }
}
