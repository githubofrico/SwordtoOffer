package Offer25;

import java.util.ArrayList;

import cn.edu.tju.rico.inttree.BinaryTree;
import cn.edu.tju.rico.inttree.TreeNode;

/**
 * Title: 二叉树中和为某一值的路径(前序遍历的应用)
 * Description:输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author rico
 * @created 2017年5月31日 下午3:49:33
 */
public class Solution {

	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();    // 路径(全局变量)
	ArrayList<TreeNode> path = new ArrayList<TreeNode>();   // 经过结点(全局变量)

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root != null) {    // 递归终止条件
			path.add(root);    // 沿途结点
			FindPath(root.left, target);  // 从左子树找，递归调用
			FindPath(root.right, target);  // 从右子树找，递归调用

			// 叶子结点，路径的终点
			if (root.left == null && root.right == null) {
				//路径上的结点求和
				int sum = 0;
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (TreeNode node : path) {
					sum += node.val;
					temp.add(node.val);
				}
				
				// 路径上结点的和是否与目标值相等
				if (sum == target) {   
					paths.add(temp);
				}
			}
			
			// 当前路径
			if (!path.isEmpty()) {
				path.remove(path.size() - 1);
			}
		}
		return paths;
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTree.createBinaryTree(
				"2(3(2(2,3),4),5(0(2,),2(,1)))", null);
		BinaryTree.printBinaryTree(root);
		System.out.println();
		System.out.println("----------------");
		ArrayList<ArrayList<Integer>> paths = new Solution().FindPath(root, 10);
		for (ArrayList<Integer> arrayList : paths) {
			System.out.println(arrayList);
		}
	}
}
