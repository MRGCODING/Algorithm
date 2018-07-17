package 剑指Offer;

import Offer.pojo.TreeNode;

public class 二叉树的镜像 {
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if (root.left != null)
			Mirror(root.left);
		if (root.right != null)
			Mirror(root.right);
		return;
	}
}
