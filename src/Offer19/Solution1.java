package Offer19;

import java.util.LinkedList;

/**
 * Title: 二叉树的镜像(画图找规律，迭代算法)，二叉树前序遍历的应用 
 * Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * @author rico
 * @created 2017年6月15日 上午9:30:37
 */
public class Solution1 {
	public void Mirror(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();   // 临时存储栈
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				// 先对调左右子树
				TreeNode tmp = root.left;
				root.left = root.right;
				root.right = tmp;
				
				stack.push(root.right);   // 将根结点的右子树入栈
				root = root.left;  // 先求根结点的左子树的镜像
			} else {
				root = stack.pop();
			}
		}
	}
}