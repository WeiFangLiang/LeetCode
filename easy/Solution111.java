package com.LeetCode.easy;
/**
 * 二叉树的最小深度(不会)
 * 		和最大深度还不太一样，需要注意左子树或者右子树为空的特殊情况
 * @author WeiFangLiang
 *
 */
public class Solution111 {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null)  return 1 + minDepth(root.right);
		if(root.right == null) return 1 + minDepth(root.left);
		//左右子树都不为空
		int l = minDepth(root.left);
		int r = minDepth(root.right);
		return l < r ? l + 1 : r + 1;
    }
}
