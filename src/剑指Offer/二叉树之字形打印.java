package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

import Offer.pojo.TreeNode;

public class 二叉树之字形打印 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return res;

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s1.add(pRoot);
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (!s1.isEmpty()) {
					TreeNode p = s1.pop();
					temp.add(p.val);
					if (p.left != null)
						s2.add(p.left);
					if (p.right != null)
						s2.add(p.right);
				}
				res.add(temp);

			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (!s2.isEmpty()) {
					TreeNode p = s2.pop();
					if (p.right != null)
						s1.add(p.right);
					if (p.left != null)
						s1.add(p.left);
					temp.add(p.val);

				}
				res.add(temp);
			}
		}
		return res;
	}
}
