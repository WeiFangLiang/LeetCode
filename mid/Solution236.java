package com.LeetCode.mid;

import com.LeetCode.easy.TreeNode;

/**
 * 二叉树的最近公共祖先（不会）
 * @author WeiFangLiang
 *
 */
public class Solution236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(root == null || root == p || root == q) return root; 
		 TreeNode left = lowestCommonAncestor(root.left,p,q);
		 TreeNode right = lowestCommonAncestor(root.right,p,q);
		 return left == null ? right : right == null ? left : root; 
	 }
}
