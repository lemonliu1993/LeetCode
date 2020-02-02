package com.lemon.leetcode.classify.hashAndString;

import java.util.Arrays;

/**
 * 哈希排序
 * Created by lemoon on 20/2/2 下午5:16
 */
public class LPrepare_HashSort {

    public static void main(String[] args) {
        int[] random = new int[10];
        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * 1000 + 1);
        }
        System.out.println(Arrays.toString(random));
        int[] hasnMap = new int[1000];
        for (int i = 0; i < random.length; i++) {
            hasnMap[random[i]]++;
        }

        for (int i = 0; i < hasnMap.length; i++) {
            for (int j = 0; j < hasnMap[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
