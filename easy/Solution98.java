package com.LeetCode.easy;
/**
 * 验证二叉搜索树(不会)
 * 		方法一、中序遍历二叉树
 * 		方法二、递归
 * 		注：空树返回 true
 * @author WeiFangLiang
 *
 */
public class Solution98 {
	 public static boolean helper(TreeNode node, Integer lower, Integer upper) {
		    if (node == null) return true;

		    int val = node.val;
		    if (lower != null && val <= lower) return false;
		    if (upper != null && val >= upper) return false;

		    if (! helper(node.right, val, upper)) return false;
		    if (! helper(node.left, lower, val)) return false;
		    return true;
		  }

	  public static boolean isValidBST(TreeNode root) {
	    return helper(root, null, null);
	  }
		  
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		node2.left = node1;
		node2.right = node3;
		
		boolean bst = isValidBST(node2);
		System.out.println(bst);
	}
}
