package com.LeetCode.easy;

public class Solution203 {
	//100%  94.42%
	public static ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		ListNode cur = head;
		ListNode temp = new ListNode(Integer.MIN_VALUE);
		ListNode pre = temp;
		temp.next = head;
		while(cur != null) {
			if(cur.val == val) {
				pre.next = cur.next;
				cur = pre.next;
			}else {
				pre = cur;
				cur = cur.next;
			}			
		}
		return temp.next;
    }
}
