package Offer39;

/**
 * Title:二叉树的深度 (递归算法的设计与应用)
 * Description:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author rico
 * @created 2017年6月26日 下午4:02:00
 */
public class Solution {
	public int TreeDepth(TreeNode root) {
		if (root == null) {  // 递归终止条件
			return 0;  // 简单情境下的处理
		} else {  // 缩小规模，递归调用
			int h1 = TreeDepth(root.left);
			int h2 = TreeDepth(root.right);
			return h2 > h1 ? h2 + 1 : h1 + 1;
		}
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
