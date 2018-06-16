package 剑指Offer常用和待结合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Offer.pojo.TreeNode;

public class 二叉树遍历 {
	// 任何递归实现的程序都可以改用栈实现。比如，先序遍历时用栈维护待访问结点；先将根结点入栈，再将右孩子结点入栈、左孩子结点入栈。
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return result;
	}

	// 中序遍历，栈维护已访问结点。一个结点只有当其左孩子结点已访问时，才能出栈，然后入栈右孩子结点；否则，则入栈左孩子结点。
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left != null) {
				stack.push(node.left);
				node.left = null; // its left child has been visited
			} else {
				result.add(node.val);
				stack.pop();
				if (node.right != null)
					stack.push(node.right);
			}
		}
		return result;
	}

	// 后序遍历，栈也维护已访问结点。一个结点只有当其左右孩子结点均已访问时，才能出栈；否则，则依次入栈右孩子结点、左孩子结点。
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				result.add(node.val);
				stack.pop();
			} else {
				if (node.right != null) {
					stack.push(node.right);
					node.right = null; // its right child has been visited
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null; // its left child has been visited
				}
			}
		}
		return result;
	}

	// 层次遍历为二叉树的BFS，是指按照结点的层级依次从左至右访问。实现层序遍历需要借助于队列，用以维护待访问的结点。
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelList = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(levelList);
		}
		return result;
	}
}
