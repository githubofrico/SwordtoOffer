package RebuildBinaryTree6;

import java.util.Arrays;

/**
 * Title: 前序和中序遍历结果构建二叉树
 * Description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author rico
 * @created 2017年5月30日 下午10:01:44
 */
public class RebuildBinaryTree {
	  
	/**     
	 * @description 递归算法
	 * @author rico       
	 * @created 2017年5月30日 下午10:04:09     
	 * @param pre
	 * @param in
	 * @return     
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre != null && in != null && pre.length == in.length
				&& pre.length != 0) {
			TreeNode root = new TreeNode(pre[0]);
			int index = 0;
			while (in[index] != pre[0]) {
				index++;
			}
			if (index > 0) {  //左子树，递归终止条件(没有左子树)
				int[] left_pre = Arrays.copyOfRange(pre, 1, index + 1);
				int[] left_in = Arrays.copyOfRange(in, 0, index);
				root.left = reConstructBinaryTree(left_pre, left_in);
			}
			if (index < pre.length - 1) {  // 递归终止条件(没有右子树)
				int[] right_pre = Arrays
						.copyOfRange(pre, index + 1, pre.length);
				int[] right_in = Arrays.copyOfRange(in, index + 1, pre.length);
				root.right = reConstructBinaryTree(right_pre, right_in);
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };

		RebuildBinaryTree tree = new RebuildBinaryTree();
		System.out.println(tree.printBinaryTree(tree.reConstructBinaryTree(pre,
				in)));
	}

	/**
	 * @description 以广义表的形式打印二叉树：前序遍历的应用
	 * @author rico
	 * @created 2017年5月24日 上午8:13:08
	 * @param root
	 * @return
	 */
	public String printBinaryTree(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(root.data);
			if (root.left != null || root.right != null) {
				sb.append('(');
				sb.append(printBinaryTree(root.left));
				sb.append(',');
				sb.append(printBinaryTree(root.right));
				sb.append(')');
			}
		}
		return sb.toString();
	}
}

/**
 * Title: 树的结点 Description:
 * 
 * @author rico
 * @created 2017年5月29日 下午9:56:09
 */
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}
