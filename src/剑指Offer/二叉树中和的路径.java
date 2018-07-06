package 剑指Offer;

import java.util.ArrayList;

import Offer.pojo.TreeNode;

public class 二叉树中和的路径 {
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

		if (root == null)
			return res;
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)
			res.add(new ArrayList<Integer>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);
		return res;
	}
}
