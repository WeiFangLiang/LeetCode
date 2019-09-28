package com.LeetCode.easy;

import java.util.Arrays;

public class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//91.50%  82%
		if(m < 1) {
			Arrays.sort(nums2);
			for(int i = 0;i < n;i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
        for(int i = 0;i < n;i++) {
        	nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
