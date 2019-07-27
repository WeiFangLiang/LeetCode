package com.LeetCode.easy;
/**
 * 二叉树的最大深度，完美掌握
 * 		1、递归
 * 		2、BFS
 * 		3、DFS
 * @author WeiFangLiang
 *
 */
public class Solution104 {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return l > r ? l + 1 : r + 1;
    }
}
