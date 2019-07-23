package com.LeetCode.easy;
/**
 * 二叉搜索树的最近公共祖先（不会）
 * @author WeiFangLiang
 *
 */
public class Solution235 {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 //方法一、可照搬二叉树的做法
		 if(root == null || root == p || root == q) return root; 
		 TreeNode left = lowestCommonAncestor(root.left,p,q);
		 TreeNode right = lowestCommonAncestor(root.right,p,q);
		 return left == null ? right : right == null ? left : root; 
	 }
	 //方法二、利用二叉搜索树的大小关系
	 public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		 if(root.val > p.val && root.val > q.val) {  //说明 p、q都在左子树
			 return lowestCommonAncestor2(root.left,p,q);
		 }
		 if(root.val < p.val && root.val < q.val) {  //说明p、q都在右子树
			 return lowestCommonAncestor2(root.right,p,q);
		 }
		 return root;     //说明一个在根的左子树，一个在根的右子树
	 }
	 //方法二的非递归版(迭代法)
	 public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
	       
		 int pVal = p.val;
		 int qVal = q.val;
		 TreeNode node = root;

        while (node != null) {

            int parentVal = node.val; //就拿node的值与p、q作比较，一直找到处于p、q中间的node

            if (pVal > parentVal && qVal > parentVal) { 
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {  //如果 node 的值，处于 p、q 之间，那祖先就是 node
                return node;
            }
        }
	        return null;
	 }
}
