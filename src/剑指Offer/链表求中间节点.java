package 剑指Offer;

import Offer.pojo.ListNode;

public class 链表求中间节点 {
	void Medium(ListNode head) {
		if (head == null)
			return;
		ListNode fast, slow;
		fast = slow = head;
		while (fast != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
	}
}
