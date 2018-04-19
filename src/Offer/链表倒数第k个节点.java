package Offer;

import Offer.pojo.ListNode;

public class 链表倒数第k个节点 {
	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode pre = head;
		int n = 0;
		while (head != null) {
			n++;
			head = head.next;
		}
		if (n < k)
			return null;
		for (int i = 0; i < n - k; i++) {
		}
		return pre;
	}
}
