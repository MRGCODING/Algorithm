package 剑指Offer;

import java.util.Stack;

import Offer.pojo.TreeNode;

/**
 * 中序遍历,记录遍历过的节点数
 * 
 * @author Lenovo
 *
 */
public class 树二叉搜索树的第k个节点 {
	TreeNode KthNode(TreeNode pRoot, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int index = 0;
		if (pRoot == null || k == 0)
			return null;
		while (pRoot != null || !stack.empty()) {
			while (pRoot != null) {
				stack.push(pRoot);
				pRoot = pRoot.left;
			}
			if (!stack.empty()) {
				pRoot = stack.pop();
				index++;
				if (index == k)
					return pRoot;
				pRoot = pRoot.right;
			}
		}
		return null;
	}
}
