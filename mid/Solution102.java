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
		//方法1：迭代--BFS	   98.7%  43.8%
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
	//方法2：深度优先 DFS	 98.7%  50%
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)  return res;
		DFS(root, 0, res);
	    return res;
	}
	private void DFS(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        /**
         * 0层----res是空的，所以new一个ArrayList
         * 1层----res有一个ArrayList(保存0层结果的)，需要再new一个ArrayList
         * 2层----res有两个ArrayList(保存0,1层结果的)，需要再new一个ArrayList
         */
        if (res.size() == level) {//说明还缺一个保留level层结果的ArrayList
        	res.add(new ArrayList<>());
        }
        //当前值加入当前层
        res.get(level).add(root.val);
        DFS(root.left, level + 1, res);
        DFS(root.right, level + 1, res);
    }
}
