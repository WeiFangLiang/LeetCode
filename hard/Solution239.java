package com.LeetCode.hard;

import java.util.LinkedList;

/**
 * 活动窗口最大值(不会)
 * 		1、用优先队列（大顶堆） 
 * 		2、双端队列（数组），更优
 * @author WeiFangLiang
 *
 */
public class Solution239 {
	//1.暴力		34%   94%
 	public int[] maxSlidingWindow(int[] nums, int k) {
 		if(nums == null || nums.length < k || k < 1) return new int[0];
 		int len = nums.length;
	    int[] res = new int[len - k + 1];//存放结果
	    for(int i = 0;i < len - k + 1;i++) {//挨个遍历数组元素
	    	int max = Integer.MIN_VALUE;
	    	for(int j = i;j < i +  k;j++) {//从当前位置往后遍历k个元素，也就是遍历当前窗口
	    		max = Math.max(max, nums[j]);
	    	}
	    	res[i] = max;
	    }
	    return res;
 	}
 	//2.双端队列：首到尾严格递减		80%  96%
 	public int[] maxSlidingWindow1(int[] nums, int k) {
 		if(nums == null || nums.length < k || k < 1) return new int[0];
 		LinkedList<Integer> qmax = new LinkedList<>();//存储数组下标
 		int[] res = new int[nums.length - k + 1];
 		int index = 0;
 		for(int i = 0;i < nums.length;i++) {
 			//如果不为空，就进行大小关系判断
 			while(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
 				qmax.pollLast();//只要是<=当前元素的，全部删掉
 			}
 			qmax.addLast(i);
 			if(qmax.peekFirst() == i - k) qmax.pollFirst(); //如果队列中最早的下标满足过时条件，删掉 
 			//数组下标遍历到 >= k- 1时，才会形成窗口，产生一个该窗口的最大值
 			if(i >= k - 1) res[index++] = nums[qmax.peekFirst()];
 		}
 		return res;
 	}
}
