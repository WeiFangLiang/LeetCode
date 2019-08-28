package com.LeetCode.easy;

/**
 * 反转链表
 * 			小结：
 * 					1、前几次代码都是死循环
 * 					2、先从纸上写写逻辑
 * @author WeiFangLiang
 *
 */
public class Solution206 {
	//超过86%，55%
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = q.next;
        p.next = null; //先断链
        while(r != null) {
        	q.next = p;
        	p = q;
        	q = r;
        	r = r.next;
        }
        q.next = p;  //单独处理最后一个节点
        head = q;
        return head;
    }
	//王铮大神版
	public static ListNode reverseList2(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
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

