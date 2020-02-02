package com.lemon.leetcode.classify.hashAndString;

/**
 * Created by lemoon on 20/2/2 下午5:06
 */
public class LPrepare_StringHash {


    public static void main(String[] args) {
        int[] charMap = new int[128];
        String s = "asfdzxvaxxt";
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i)]++;
        }

        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] != 0) {
//                System.out.println(i + "次数" + charMap[i]);
                System.out.printf("%c"+"次数"+charMap[i]+"\n",i);
            }
        }
    }
}
