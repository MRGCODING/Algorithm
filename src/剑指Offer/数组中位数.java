package 剑指Offer;

public class 数组中位数 {
	double findMedianSortedArrays(int[] A, int[] B) {
		int sizeA = A.length, sizeB = B.length;
		if (sizeA <= 0 && sizeB <= 0) {
			return 0;
		}

		int total = sizeA + sizeB;
		if (total % 2 == 1) {
			return findKth(A, 0, B, 0, total / 2 + 1);
		} else {
			return (findKth(A, 0, B, 0, total / 2) + findKth(A, 0, B, 0, total / 2 + 1)) / 2;
		}
	}

	double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		// 首先需要让数组1的长度小于或等于数组2的长度
		if (nums1.length - i > nums2.length - j) {
			return findKth(nums2, j, nums1, i, k);
		}
		// 判断小的数组是否为空，为空的话，直接在另一个数组找第K个即可
		if (nums1.length == i) {
			return nums2[j + k - 1];
		}
		// 当K = 1时，表示我们要找第一个元素，只要比较两个数组的第一个元素，返回较小的那个即可
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}

		int pa = Math.min(i + k / 2, nums1.length), pb = j + k - pa + i;

		if (nums1[pa - 1] < nums2[pb - 1]) {
			return findKth(nums1, pa, nums2, j, k - pa + i);
		} else if (nums1[pa - 1] > nums2[pb - 1]) {
			return findKth(nums1, i, nums2, pb, k - pb + j);
		} else {
			return nums1[pa - 1];
		}
	}
}
