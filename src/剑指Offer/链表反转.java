package 剑指Offer;

import Offer.pojo.ListNode;

public class 链表反转 {
	public ListNode ReverseList(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
        return pre;
    }
}
