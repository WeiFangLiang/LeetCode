package com.LeetCode.mid;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

//powcai的思路三
public class Solution138 {
	public Node copyRandomList(Node head) {
		if(head == null) return null;
		Node cur = head;
		while(cur != null) {  //原链表基础上，每个节点后面添加同值的节点
			Node temp = cur.next;
			cur.next = new Node(cur.val,null,null);
			cur.next.next = temp;
			cur = temp;
		}
		//照搬原来的随机指针
		cur = head;
		while(cur != null) {
			if(cur.random != null) cur.next.random = cur.random.next;
			cur = cur.next.next;
		}
		//拆分
		cur = head;
		Node copy_head = cur.next;
		Node copy_cur = copy_head;
		while(copy_cur.next != null) {
			cur.next = cur.next.next;
			cur = cur.next;
			copy_cur.next = copy_cur.next.next;
			copy_cur = copy_cur.next;
		}
		cur.next = null;
		return copy_head;
    }
}
