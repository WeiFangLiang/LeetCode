package com.LeetCode.hard;

class Solution {
	//97%  79.23%  《代码面试指南》P76
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2) {
			return head;
		}
		ListNode cur = head;
		ListNode start = null;
		ListNode pre = null;
		ListNode next = null;
		int count = 1;
		while(cur != null) {
			next = cur.next;
			if(count == k) {
				start = pre == null ? head : pre.next;
				head = pre == null ? cur : head;
				resign2(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
    }
    private void resign2(ListNode left, ListNode start, ListNode end, ListNode right) {
		ListNode pre = start;
		ListNode cur = start.next;
		ListNode next = null;
		while(cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null) {
			left.next = end;
		}
		start.next = right;
	}
}
