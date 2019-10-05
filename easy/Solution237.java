package com.LeetCode.easy;
/**
 * 这道题简直是脑筋急转弯！！！，因为根本没传head，所以不能遍历链表！！
 * @author WeiFangLiang
 *
 */
public class Solution237 {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
    }
}
