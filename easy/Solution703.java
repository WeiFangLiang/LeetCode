package com.LeetCode.easy;

import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 * 		数据集是动态变化的，要始终找出第K大元素，看的解析
 * 		小结：
 * 			小顶堆的首次使用！，K个元素，堆顶元素就是所求的值
 * @author WeiFangLiang
 *
 */
public class Solution703 {
	 public static void main(String[] args) {
	    	int[] nums = {4,5,8,2};
	    	KthLargest kl = new KthLargest(3,nums);
	    	kl.add(3);
	    	kl.add(5);
	    	kl.add(10);
	    	kl.add(9);
	    	System.out.println(kl.add(4));
		}
}

class KthLargest {
	final PriorityQueue<Integer> q;  // 优先级队列默认就是小顶堆
	final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);  //小顶堆的大小为 k 
        for(int a : nums) {
        	add(a);  //将 元素 a 插入优先队列，优先队列中的add() 还是会调用 offer(a)
        	//q.add(a)    不是调用q的 add()
        }           //但是这个不是优先队列的 add() 而是下面的add()！！！这是个隐蔽的坑
    }
    
    public int add(int val) {  //向数据集中添加 val ，并返回最新数据集的第K大元素
        if(q.size() < k) { //若小顶堆没满
        	q.offer(val);
        }else if(q.peek() < val) { //若满了，且堆顶元素小于 val 
        	q.poll(); //移除堆顶元素
        	q.offer(val); // 将元素 val 插入优先级队列
        }
        return q.peek(); //返回堆顶元素
    }
}