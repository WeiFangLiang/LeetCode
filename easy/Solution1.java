package com.LeetCode.easy;

import java.util.HashMap;

public class Solution1 {
	//1.暴力	24%  91%
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[2];
        for(int i = 0;i < nums.length;i++) {
        	for(int j = i + 1;j < nums.length;j++) {
        		if(nums[i] + nums[j] == target) return new int[] {i, j};
        	}
        }
        return new int[2];
    }
	
	//2.HashMap		76%  93%
	public int[] twoSum1(int[] nums, int target) {
		if(nums == null || nums.length < 2) return new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();//key：数组元素.。 value：该元素的数组下标
		for(int i = 0;i < nums.length;i++) {
			if(map.containsKey(target - nums[i])) {//map是否有差值
				return new int[] {map.get(target - nums[i]), i};//map中的元素的下标肯定是小于当前下标 i 的
			}else {
				map.put(nums[i], i);
			}
		}
		return new int[2];
	}
}
