package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
	//1.递归             100%  40%
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		helper(root, res);
		return res;
    }
	
	public void helper(TreeNode root, List<Integer> res) {
		if(root == null) return;
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
	
	//2.栈  非递归
}
