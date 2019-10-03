package com.LeetCode.easy;

import java.util.Arrays;

public class Solution561 {
	//78.21%  98.32%
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;) {
        	sum += nums[i];
        	i += 2;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		int sum = arrayPairSum(nums);
		System.out.println(sum);
	}
}
