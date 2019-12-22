package com.LeetCode.hard;

import java.util.Stack;

public class Solution84 {
	
	//1.暴力  		超时
	public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i = 0;i < heights.length;i++) {
        	for(int j = i;j < heights.length;j++) {
        		int minHeight = Integer.MAX_VALUE;
        		for(int k = i;k <= j;k++) { //这一层循环是为了找到i---j之间的最小高度
        			minHeight = Math.min(minHeight, heights[k]);
        		}
        		maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        	}
        }
        return maxArea;
    }
	
	//2.优化的暴力		18%    87%
	public int largestRectangleArea2(int[] heights) {
		int maxArea = 0;
		for(int i = 0;i < heights.length;i++) {
			int minHeight = Integer.MAX_VALUE;
			for(int j = i;j < heights.length;j++) {
				minHeight = Math.min(minHeight, heights[j]);//j每移动一次，就直接计算minHeight，省掉第三重循环
				maxArea = Math.max(maxArea, minHeight * (j - i + 1));
			}
		}
		return maxArea;
	}
	
	//3.栈     栈底到栈顶  元素递增     每一个栈中的元素，它的下方元素既是它的左边界
	public int largestRectangleArea3(int[] heights) {
		Stack<Integer> stack = new Stack<>(); //存储下标
		stack.push(-1); //类似哨兵，数组的左边界
		int maxArea = 0;
		for(int i = 0;i < heights.length;i++) {
			//当前元素高度不大于栈顶元素高度，即栈顶元素遇到了右边界
			while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
				//pop在前，所以 i - stack.peek() 的peek宽度多算了一步，需要减去1
				maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
			}
			stack.push(i);//只有当前元素高度大于栈顶元素高度，则入栈
		}
		while (stack.peek() != -1)
			maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxArea;

	}
}
