package com.lemon.leetcode.classify.hashAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode187
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 示例：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * Created by lemoon on 20/2/4 上午9:37
 */
public class L5_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        String str;
        for (int i = 0; i < s.length() - 9; i++) {          //注意：这里是-9
            str = s.substring(i, i + 10);
            if (map.containsKey(str)) {
                if (map.get(str) == 1) {
                    result.add(str);
                }
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > 1) {
//                result.add(entry.getKey());
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(s);
        System.out.println(s.substring(0, 10));
        System.out.println(new L5_Repeated_DNA_Sequences().findRepeatedDnaSequences(s));
        System.out.println(new L5_Repeated_DNA_Sequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
