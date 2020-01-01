package com.lemon.leetcode.L100;

/**
 * Created by lemoon on 19/12/30 下午11:28
 */
public class L6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < numRows || numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sbs[i].append(s.charAt(index++));
            }
            for (int i = numRows - 2; i >= 1 && index < s.length(); i--) {
                sbs[i].append(s.charAt(index++));
            }
        }


        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new L6_ZigZag_Conversion().convert("PAYPALISHIRING", 3));
    }
}
