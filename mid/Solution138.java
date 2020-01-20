package com.LeetCode.mid;

class DDNode {
    public int val;
    public DDNode next;
    public DDNode random;

    public DDNode() {}

    public DDNode(int _val,DDNode _next,DDNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

//powcai的思路三
public class Solution138 {
	public DDNode copyRandomList(DDNode head) {
		if(head == null) return null;
		DDNode cur = head;
		while(cur != null) {  //原链表基础上，每个节点后面添加同值的节点
			DDNode temp = cur.next;
			cur.next = new DDNode(cur.val,null,null);
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
		DDNode copy_head = cur.next;
		DDNode copy_cur = copy_head;
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
