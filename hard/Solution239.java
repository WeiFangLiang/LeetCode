package com.LeetCode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 活动窗口最大值(不会)
 * 		1、用优先队列（大顶堆） 
 * 		2、双端队列（数组），更优
 * @author WeiFangLiang
 *
 */
public class Solution239 {
	//官方解，有些细节不明白
	ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
	int [] nums;
	
	public void clean_deque(int i, int k) { //最难理解的就是这个函数

		if (!deq.isEmpty() && deq.getFirst() == i - k) //？
			deq.removeFirst();
		
		while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                   
			deq.removeLast();
	}
	
 	public int[] maxSlidingWindow(int[] nums, int k) {
 		    int n = nums.length;
 		    if (n * k == 0) return new int[0];
 		    if (k == 1) return nums;

 		    this.nums = nums;
 		    int max_idx = 0;  //记录最大值
 		    for (int i = 0; i < k; i++) {
 		    	clean_deque(i, k);
 		        deq.addLast(i);  //队列存的是数组下标
 		      if (nums[i] > nums[max_idx]) max_idx = i;
 		    }
 		    int [] output = new int[n - k + 1];
 		    output[0] = nums[max_idx];

 		    // build output
 		    for (int i  = k; i < n; i++) {
 		      clean_deque(i, k); //每次clean队列之后，最大值的索引都会到队首
 		      deq.addLast(i);
 		      output[i - k + 1] = nums[deq.getFirst()];//将最大值放入结果数组
 		    }
 		    return output;
 		  }
 	public static void main(String[] args) {
 		Solution239 ss = new Solution239();
 		int[] nums = {7,2,4};
 		int[] output = ss.maxSlidingWindow(nums,2);
 		System.out.println(Arrays.toString(output));
	}
}
