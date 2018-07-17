package 剑指Offer;

import Offer.pojo.ListNode;

/**
 * 首先法找到链表中间节点，然后递归的对两个子链表排序
 * 把两个排好序的子链表合并成一条有序的链表。
 * 归并排序作为链表排序的最佳选择，保证了最好和最坏时间复杂度都是nlogn，而且它在数组排序中广受诟病的空间复杂度在链表排序中也从O(n)降到了O(1)
 * 
 * @author Lenovo
 *
 */
public class 链表排序 {
	public ListNode mergeSort(ListNode first, int length) {
		if (length == 1) {
			return first;
		} else {
			ListNode middle = new ListNode();
			ListNode tmp = first;
			/**
			 * 后期会对这里进行优化，通过一次遍历算出长度和中间元素
			 */
			for (int i = 0; i < length; i++) {
				if (i == length / 2) {
					break;
				}
				middle = tmp;
				tmp = tmp.next;
			}
			/**
			 * 这里是链表归并时要注意的细节
			 */
			ListNode right = middle.next;
			middle.next = null;

			ListNode leftStart = mergeSort(first, length / 2);
			ListNode rightStart;
			if (length % 2 == 0) {
				rightStart = mergeSort(right, length / 2);
			} else {
				rightStart = mergeSort(right, length / 2 + 1);
			}
			return mergeList(leftStart, rightStart);
		}
	}

	public ListNode mergeList(ListNode left, ListNode right) {
		ListNode head = new ListNode();
		ListNode result = head;
		/**
		 * 思想就是两个链表同时遍历，将更小的元素插入结果中，同时更大的元素所属的链表的指针向下移动
		 */
		while (!(null == left && null == right)) {
			ListNode tmp;
			if (left == null) {
				result.next = right;
				break;
			} else if (right == null) {
				result.next = left;
				break;
			} else if (left.val >= right.val) {
				tmp = left;
				result.next = left;
				result = tmp;
				left = left.next;
			} else {
				tmp = right;
				result.next = right;
				result = tmp;
				right = right.next;
			}
		}
		return head.next;
	}
}
