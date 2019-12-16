package com.LeetCode.mid;

public class Solution11 {
	//1.暴力法O(n*n)：枚举所有可能的面积		28%, 94%
	public int maxArea1(int[] height) {
        int max = 0;//记录最大面积
        for(int i = 0;i < height.length;i++) {
        	for(int j = i + 1;j < height.length;j++) {
        		int cur_area = getArea(height, i, j);//当前面积
        		max = Math.max(max, cur_area);
        	}
        }
        return max;
    }

	private int getArea(int[] height, int i, int j) {
		return Math.min(height[i], height[j]) * (j - i);
	}
	
	//2.O(n)  双指针i, j指向首和尾，不断向中间收敛		93%, 93%
	public int maxArea2(int[] height) {
		int max = 0;
		for(int i = 0, j = height.length - 1;i < j;) {
			int minHeight = height[i] < height[j] ? height[i++] : height[j--];//记录并移动两个指针中较矮的那个
			int area = (j - i + 1) * minHeight;//上一行i++或者j--了，所以需要j-i再+1
			max = Math.max(max, area);
		}
		return max;
	}
}
