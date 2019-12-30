package com.LeetCode.mid;

import java.util.ArrayList;

public class Solution98 {
	//38%   41%   先中序遍历这颗树，然后遍历结果数组，严格递增则为true
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true; //注意：空树返回true
		TreeNode cur = root;
		ArrayList<Integer> res = inOrder(cur);
		for(int i = 0;i < res.size() - 1;i++) {
			if(res.get(i) >= res.get(i + 1)) return false;//相等的值，也是false
		}
		return true;
    }
	public ArrayList<Integer> inOrder(TreeNode node) {
		ArrayList<Integer> res = new ArrayList<>();
		if(node == null ) return res;
		helper(node, res);
		return res;
	}
	public void helper(TreeNode node, ArrayList<Integer> res) {
		if(node == null) return;
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);
	}
	
	//-------------------2、递归：官方题解-------------------------
	//87% 24%
	public boolean isValidBST2(TreeNode root) {
		return helper2(root, null, null);
	}
	
	public boolean helper2(TreeNode node, Integer lower, Integer upper) {
		if(node == null) return true;
		int val = node.val;//当前节点的值
		if(lower != null && val <= lower) return false;
		if(upper != null && val >= upper) return false;
		if(!helper2(node.right, val, upper)) return false;//是右子树递归调用的下界
		if(!helper2(node.left, lower, val)) return false;//是左子树递归的上界
		return true;
	}
}
