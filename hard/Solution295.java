package com.LeetCode.hard;

import java.util.PriorityQueue;

/**
 * 求中位数，时间有点慢
 * @author Administrator
 *
 */
public class Solution295 {

}
	//31.36%  35.82%
class MedianFinder {
	// 奇数：对于 1 2 3 4 5  ，（中位数）3 是大顶堆的堆顶元素
	//偶数：对于 1 2 3 4 ，（中位数）2.5是大顶堆的堆顶元素 和 小顶堆堆顶元素的平均数
	// 大顶堆元素 <= 小顶堆，且大顶堆在前
	private int count;  //大顶堆和小顶堆的元素个数之和
	private PriorityQueue<Integer> maxHeap;  //这个稍后处理成大顶堆
	private PriorityQueue<Integer> minHeap; //默认就是小顶堆
	

    /** initialize your data structure here. */
    public MedianFinder() {
    	count = 0;
    	minHeap = new PriorityQueue<>();
    	maxHeap = new PriorityQueue<>((x, y) -> y - x);  // 第一次运用lambda表达式，改为降序排列--->大顶堆
    }
    
    public void addNum(int num) {
    	count += 1;
    	maxHeap.offer(num); //优先加入大顶堆
    	minHeap.add(maxHeap.poll()); //再加入小顶堆
    	// 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
    	if((count & 1) != 0) {  //位操作奇偶判别式-----牛逼！！
    		maxHeap.add(minHeap.poll());
    	}
    } // 这个方法才是最关键的，它实时更新了两个堆的堆顶元素，确保了这俩数是整个数据流的中间数据
    
    public double findMedian() {
    	if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数就是大顶堆的堆顶元素
            return (double) maxHeap.peek();
        }
    }
}
