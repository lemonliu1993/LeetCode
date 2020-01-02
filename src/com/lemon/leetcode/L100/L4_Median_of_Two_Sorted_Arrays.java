package com.lemon.leetcode.L100;

/**
 * Created by lemoon on 19/12/24 下午11:21
 */
public class L4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            throw new RuntimeException();
        }
        int len1 = 0;
        if (nums1 != null) {
            len1 = nums1.length;
        }

        int len2 = 0;
        if (nums2 != null) {
            len2 = nums2.length;
        }

        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            return findK(nums1, 0, len1-1, nums2, 0, len2-1, (totalLen + 1) / 2);
        } else {
            double k1 = findK(nums1, 0, len1-1, nums2, 0, len2-1, totalLen / 2);
            double k2 = findK(nums1, 0, len1-1, nums2, 0, len2-1, totalLen / 2 + 1);
            return (k1 + k2) / 2.0;
        }
    }

    private double findK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return findK(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[k + start2-1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int partA = Math.min(len1, k / 2);
        int partB = k - partA;
        if (nums1[start1 + partA - 1] == nums2[start2 + partB - 1]) {
            return nums1[start1 + partA - 1];
        } else if (nums1[start1 + partA - 1] < nums2[start2 + partB - 1]) {
            return findK(nums1, start1 + partA, end1, nums2, start2, end2, k - partA);
        } else {
            return findK(nums1, start1, end1, nums2, start2 + partB, end2, k - partB);
        }
    }

    public static void main(String[] args) {
//        int[] a1 = new int[]{1, 2};
        int[] a1= new int[]{1,2,3,5};
//        int[] a2 = new int[]{3, 4};
        int[] a2=new int[]{4};
        System.out.println(new L4_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(a1, a2));
    }
}
