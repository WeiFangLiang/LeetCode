package com.LeetCode.mid;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution215 {
	//56%		42%     自己想的
	public int findKthLargest(int[] nums, int k) {
		//优先级队列默认是基于小顶堆实现的
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(int i = 0;i < k;i++) { //先把前 k 个 加入堆
        	minHeap.add(nums[i]);
        }
        for(int i = k;i < nums.length;i++) {
        	if(nums[i] > minHeap.peek()) {
        		minHeap.poll();
        		minHeap.add(nums[i]);
        	}
        }
        return minHeap.peek();
    }
	
	public int findKthLargest2(int[] nums, int k) {
		//最无脑的暴力算法，居然比上面的好
		// 76%		49%
		Arrays.sort(nums);
		int index = nums.length - k;
		return nums[index];
	}
}
