package 剑指Offer;

import Offer.pojo.TreeNode;

public class 树中公共节点二叉排序树 {
	public static TreeNode getLowestCommonAncestor(TreeNode rootParent, TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}

		if ((root.val - node1.val) * (root.val - node2.val) < 0) {
			return root;
		} else if ((root.val - node1.val) * (root.val - node2.val) > 0) {
			TreeNode newRoot = ((root.val > node1.val) && (root.val > node2.val)) ? root.left : root.right;
			return getLowestCommonAncestor(root, newRoot, node1, node2);
		} else {
			return rootParent;
		}
	}
}
