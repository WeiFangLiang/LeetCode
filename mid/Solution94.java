package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
	//1.递归		74%  39%
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
		helper(cur, res);
		return res;
    }
	
	public void helper(TreeNode node, List<Integer> res) {
		if(node == null) return;
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);
	}
	
	//2.栈  非递归
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
        	while(cur != null) {
        		stack.push(cur);//只要不为null就入栈
        		cur = cur.left;//指向左子节点
        	}
        	//cur为null，说明左边界到头了
        	cur = stack.pop();//开始出栈，最开始出栈的一定是最左节点
        	res.add(cur.val);//记录出栈的节点值
        	cur = cur.right;
        }
        return res;
	}
}
