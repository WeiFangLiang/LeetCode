package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历  (不会，各种遍历需要熟练)
 * 		1、BFS
 * 		2、DFS也可以，这个挺反人类的，能写出来才是牛逼
 * @author WeiFangLiang
 *
 */
public class Solution102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		//BFS
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)  return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);   //先加入一个根结点
		
		while(!q.isEmpty()) {
			int levelSize = q.size();  //每一层遍历的次数，也就是每一层的节点数
			List<Integer> currLevel  = new ArrayList<>();  //当前层
			
			for(int i = 0;i < levelSize;i++) {
				TreeNode currNode = q.poll();
				currLevel.add(currNode.val);
				if(currNode.left != null)  q.add(currNode.left);
				if(currNode.right != null)  q.add(currNode.right);	
			}
			res.add(currLevel);//遍历完一层，加入结果集中
		}
		return res;
	}
}
