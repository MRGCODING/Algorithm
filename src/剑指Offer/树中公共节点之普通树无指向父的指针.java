package 剑指Offer;

import java.util.Stack;

import Offer.pojo.TreeNode;

public class 树中公共节点之普通树无指向父的指针 {
	public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode node1,
			TreeNode node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}
		Stack<TreeNode> path1 = new Stack<TreeNode>();
		boolean flag1 = getThePathOfTheNode(root, node1, path1);
		if (!flag1) {// 树上没有node1节点
			return null;
		}
		Stack<TreeNode> path2 = new Stack<TreeNode>();
		boolean flag2 = getThePathOfTheNode(root, node2, path2);
		if (!flag2) {// 树上没有node2节点
			return null;
		}

		if (path1.size() > path2.size()) { // 让两个路径等长
			while (path1.size() != path2.size()) {
				path1.pop();
			}
		} else {
			while (path1.size() != path2.size()) {
				path2.pop();
			}
		}

		if (path1 == path2) {// 当两个节点在一条路径上时
			path1.pop();
			return path1.pop();
		} else {
			TreeNode p = path1.pop();
			TreeNode q = path2.pop();
			while (q != p) {
				p = path1.pop();
				q = path2.pop();
			}
			return p;
		}
	}

	// 获得根节点到node节点的路径
	public static boolean getThePathOfTheNode(TreeNode root, TreeNode node, Stack<TreeNode> path) {
		path.push(root);
		if (root == node) {
			return true;
		}
		boolean found = false;
		if (root.left != null) {
			found = getThePathOfTheNode(root.left, node, path);
		}
		if (!found && root.right != null) {
			found = getThePathOfTheNode(root.right, node, path);
		}
		if (!found) {
			path.pop();
		}
		return found;
	}
}
