package com.LeetCode.hard;

import java.util.Arrays;

public class Solution493 {
	//暴力
	public int reversePairs(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int count = 0;
		for(int i = 0;i < nums.length - 1;i++) {
			for(int j = i + 1;j < nums.length;j++) {
				if(nums[i] - nums[j] > nums[j]) count++;
			}
		}
		return count;
    }
	//归并排序
	public int reversePairs2(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
    }
	
	private int mergeSort(int[] nums, int s, int e) {//s--start   e--end
		if(s >= e) return 0;
		int mid = s + (e - s) / 2;
		//初始翻转对：左半部分内部 与 右半部分内部 翻转对之和
		int count = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
		//统计左右两部分之间 的翻转对 
		for(int i = s,j = mid + 1;i <= mid;i++) {
			while(j <= e && nums[i] / 2.0 > nums[j]) j++;
			count += j - (mid + 1);
		}
		Arrays.sort(nums, s, e + 1);//偷懒处理
		return count;
	}
}
