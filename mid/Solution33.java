package com.LeetCode.mid;

public class Solution33 {
	
	public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	if((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {//说明target在右半边
        		left = mid +1;
        	}else {
        		right = mid;
        	}
        }
        return left == right && nums[left] == target ? left : -1;
    }
	//思路更容易理解
	public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //如果target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;//则去前半部分继续找
                } else {
                    start = mid + 1;//否则去后半部分
                }
            } else {//若是后半段有序
            	//如果target在后半部分
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;//则去后半段继续找
                } else {
                    end = mid - 1;//否则去前半部分
                }
            }

        }
        return -1;
    }
}
