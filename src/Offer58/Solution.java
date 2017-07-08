package Offer58;

/**
 * Title: 二叉树的下一个结点
 * Description:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点
 * ，同时包含指向父结点的指针。
 * 
 * @author rico
 * @created 2017年7月7日 下午2:00:27
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode result = null;
		if (pNode != null) {
			int position = getPositionbyRoot(pNode);  // 给定节点在左子树、右子树或者是根结点
			if (position == 0) {  // 给定节点是根结点
				result = getLeftNode(pNode.right);
				return result;
			} else if (position == -1) {    // 给定节点在左子树上
				result = getLeftNode(pNode.right);   // 右子树最左边的节点
				if (result == null) {  // 右子树最左边的节点为空
					int pos = getPositionbyParent(pNode);
					result = pos == -1 ? pNode.next : pNode.next.next;
				}
				return result;
			} else {     // 给定节点在右子树上
				result = getLeftNode(pNode.right);   	// 右子树最左边的节点
				if (result == null) {   	// 右子树最左边的节点为空
					int pos = getPositionbyParent(pNode);
					result = pos == -1 ? pNode.next : result;
				}
				return result;
			}
		}
		return result;
	}

	/**
	 * @description 获取节点node为根的树中最左边的结点
	 * @author rico
	 * @created 2017年7月7日 下午8:54:07
	 * @param node
	 * @return
	 */
	public TreeLinkNode getLeftNode(TreeLinkNode node) {
		if (node == null) {
			return null;
		} else {
			TreeLinkNode cur = node;
			if (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
	}

	/**
	 * @description 获取给定节点相对于根结点的位置
	 * @author rico
	 * @created 2017年7月7日 下午8:57:06
	 * @param pNode
	 * @return
	 */
	public int getPositionbyRoot(TreeLinkNode pNode) {
		TreeLinkNode cur = pNode;
		TreeLinkNode root = null;
		TreeLinkNode tmp = null;
		if (cur != null) {
			while (cur.next != null) {
				tmp = cur;
				cur = cur.next;
			}
			root = cur;
		}

		if (root == pNode) {
			return 0; // pNode为根结点
		}
		return root.left == tmp ? -1 : 1; // -1 表示pNode为左子树上的节点，1表示pNode为右子树上的节点
	}

	/**
	 * @description 获取给定节点相对于其父节点的位置
	 * @author rico
	 * @created 2017年7月7日 下午8:57:39
	 * @param pNode
	 * @return
	 */
	public int getPositionbyParent(TreeLinkNode pNode) {
		return pNode.next.left == pNode ? -1 : 1; // -1 表示为左孩子，1表示右孩子
	}

	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(8);
		TreeLinkNode node2 = new TreeLinkNode(6);
		TreeLinkNode node3 = new TreeLinkNode(10);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node5 = new TreeLinkNode(7);
		TreeLinkNode node6 = new TreeLinkNode(9);
		TreeLinkNode node7 = new TreeLinkNode(11);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;
		node2.next = node1;

		node3.left = node6;
		node3.right = node7;
		node3.next = node1;

		node4.next = node2;

		node5.next = node2;

		node6.next = node3;

		node7.next = node3;

		Solution s = new Solution();
		System.out.println(s.getPositionbyRoot(node1));
		System.out.println(s.GetNext(node1));
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeLinkNode [val=" + val + "]";
	}
}