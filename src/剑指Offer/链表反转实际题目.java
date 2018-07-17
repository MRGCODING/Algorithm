package 剑指Offer;

import Offer.pojo.ListNode;

/**
 * https://www.nowcoder.com/discuss/86191
 * @author Lenovo
 *
 */
public class 链表反转实际题目 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode left = head;
		ListNode right = head.next;
		left.next = swapPairs(right.next);
		right.next = left;
		return right;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		ListNode index = head;
		ListNode[] temp = new ListNode[k];
		temp[0] = index;
		for (int i = 1; i < k; i++) {
			index = index.next;
			if (index == null) {
				return head;
			} else {
				temp[i] = index;
			}
		}
		temp[0].next = reverseKGroup(temp[k - 1].next, k);
		for (int i = 1; i < k; i++) {
			temp[i].next = temp[i - 1];
		}
		return temp[k - 1];
	}
}
