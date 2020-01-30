package com.lemon.leetcode.classify.binarysearchAndBST;

import java.util.Arrays;

/**
 * 预备知识，二分查找
 * 已知一个排序数组A，如A=[-1,2,5,20,90,10,207,800]
 * 另外一个乱序数组B，如B＝[50,90,3,-1,207,80]
 * 求B中的任意某个元素，是否在A中出现，结果存储在数组C中，出现用1代表，未出现用0代表，如,C=[0,1,0,1,1,0]
 * Created by lemoon on 20/1/30 下午4:15
 */
public class LPrepare_BinarySearch {

    int[] a = {-1, 2, 5, 20, 90, 10, 207, 800};
    int[] b = {50, 90, 3, -1, 207, 80};

    public int[] search_array(int[] a, int[] b) {
        int[] result = new int[b.length];
        for(int i =0;i<b.length;i++){
            result[i] = binarySearch(a,0,a.length,b[i]);
        }
        return result;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1, 2, 5, 20, 90, 10, 207, 800};
        int[] b = {50, 90, 3, -1, 207, 80};
        int[] ints = new LPrepare_BinarySearch().search_array(a, b);
        System.out.println(Arrays.toString(ints));
    }
}
