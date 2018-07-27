package 剑指Offer;

import Offer.pojo.TreeNode;

public class 二叉树对称 {
	boolean isSymmetrical(TreeNode pRoot) {
		return helper(pRoot, pRoot);
	}

	private boolean helper(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;
		if (pRoot1 == null || pRoot2 == null)
			return false;
		if (pRoot1.val != pRoot2.val)
			return false;
		return helper(pRoot1.left, pRoot2.right) && helper(pRoot1.right, pRoot2.left);
	}
}