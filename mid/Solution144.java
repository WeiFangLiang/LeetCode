package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	//2.栈  非递归		75%  40%
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				res.add(cur.val);//先记录当前根的值
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop().right;
		}
		return res;
	}
}
