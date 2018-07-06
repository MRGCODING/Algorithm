package 剑指Offer;

import Offer.pojo.TreeNode;

public class 平衡二叉树 {
	public boolean IsBalanced_Solution(TreeNode root) {
		int[] depth = new int[1];
		return helper(root, depth);
	}

	private boolean helper(TreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		boolean left = helper(root.left, depth);
		int l = depth[0];
		boolean right = helper(root.right, depth);
		int r = depth[0];
		depth[0] = Math.max(l, r) + 1;
		if (left && right) {
			if (Math.abs(l - r) <= 1) {
				return true;
			}
		}
		return false;
	}
}