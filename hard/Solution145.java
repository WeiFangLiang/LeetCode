package com.LeetCode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
	//1.递归		100%  37%
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }
	public void helper(TreeNode root, List<Integer> res) {
		if(root == null) return;
		helper(root.left, res);
		helper(root.right, res);
		res.add(root.val);
	}
	
	//2.栈    非递归   不会！ 仿照左程云的
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode cur = root;
        s1.push(cur);
        while(!s1.isEmpty()) {
        	cur = s1.pop();
        	s2.push(cur);
        	if(cur.left != null) s1.push(cur.left);
        	if(cur.right != null) s1.push(cur.right);
        }
        while(!s2.isEmpty()) {
        	res.add(s2.pop().val);
        }
        return res;
	}
}
