package Offer;

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

public class 二叉树的下一个节点 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		// 判断是否有右孩子,如果有，输出右子树最左边的孩子节点
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		// 如果没有，网上找父节点，如果是右孩子，一直向上走
		while (pNode.next != null) {
			TreeLinkNode node = pNode.next;
			if (node.left == pNode) {
				return node;
			}
			pNode = pNode.next;
		}
		return null;
		// 如果没有，往上找父节点，如果是左孩子，输出父节点
	}
}
