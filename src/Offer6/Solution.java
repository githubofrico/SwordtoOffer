package Offer6;

public class Solution {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || pre.length == 0 || in == null || in.length == 0
				|| pre.length != in.length) {
			return null;
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0,
				in.length - 1);
	}

	public TreeNode reConstructBinaryTree(int pre[], int from1, int to1,
			int in[], int from2, int to2) {
		if ((from1 > to1) || (from2 > to2)) {
			return null;
		} else {
			int s = pre[from1];
			int index = 0;
			for (int i = from2; i <= to2; i++) {
				if (s == in[i]) {
					index = i;
				}
			}
			TreeNode root = new TreeNode(s);
			root.left = reConstructBinaryTree(pre, from1 + 1, from1 + index
					- from2, in, from2, index - 1);
			root.right = reConstructBinaryTree(pre, from1 + index - from2 + 1,
					to1, in, index + 1, to2);
			return root;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
