package com.LeetCode.easy;
/**
 * 反转链表
 * 			小结：
 * 					1、前几次代码都是死循环
 * @author WeiFangLiang
 *
 */
public class Solution206 {
	public static ListNode reverseList(ListNode head) {
        // 1 2 3 4 5 null 
		ListNode i = head;
		if(i == null) {
			return null;
		}
		ListNode j = head.next;
		if(j == null) {
			return head;
		}
		ListNode k = head.next.next;
		head.next = null;
		while(k != null) {
//			j.next = i;
//			i.next = null;  这两句就死循环了,而且每次都断，最后肯定残缺
			j.next = i;
			i = j;
			j = k;
			k = k.next;
		}
		j.next = i;
		head = j;
		return head;
    }
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode head = node1;
		ListNode reList = reverseList(head);
		while(reList != null) {
			System.out.print(reList.val + " ");
			reList = reList.next;
		}
	}
}

