package 剑指Offer;

import Offer.pojo.TreeNode;

public class 树的子结构 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val)
				res = helper(root1, root2);
			if (!res)
				res = HasSubtree(root1.left, root2);
			if (!res)
				res = HasSubtree(root1.right, root2);
		}
		return res;
	}

	private boolean helper(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return helper(root1.left, root2.left) && helper(root1.right, root2.right);
	}
}
