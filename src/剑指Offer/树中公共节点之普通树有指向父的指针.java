package 剑指Offer;

import Offer.pojo.TreeNode;

public class 树中公共节点之普通树有指向父的指针 {
	public static TreeNode getLowestCommonAncestor1(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}
		int depth1 = findTheDepthOfTheNode(root, node1, node2);
		if (depth1 == -1) {
			return node2.parentNode;
		}
		int depth2 = findTheDepthOfTheNode(root, node2, node1);
		if (depth2 == -1) {
			return node1.parentNode;
		}
		// p指向较深的节点q指向较浅的节点
		TreeNode p = depth1 > depth2 ? node1 : node2;
		TreeNode q = depth1 > depth2 ? node2 : node1;
		int depth = Math.abs(depth1 - depth2);

		while (depth > 0) {
			p = p.parentNode;
			depth--;
		}
		while (p != q) {
			p = p.parentNode;
			q = q.parentNode;
		}
		return p;
	}

	// 求node1的深度，如果node1和node2在一条路径上，则返回-1，否则返回node1的深度
	public static int findTheDepthOfTheNode(TreeNode root, TreeNode node1, TreeNode node2) {
		int depth = 0;
		while (node1.parentNode != null) {
			node1 = node1.parentNode;
			depth++;
			if (node1 == node2) {
				return -1;
			}
		}
		return depth;
	}
}
