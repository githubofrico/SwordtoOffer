package SumPathBinaryTree25;

import java.util.ArrayList;
import java.util.LinkedList;

import cn.edu.tju.rico.inttree.BinaryTree;
import cn.edu.tju.rico.inttree.TreeNode;

/**
 * Title: 二叉树中和为某一值的路径(递归思路：FindPath(TreeNode root, int target) =
 * FindPath(root.left, target - root.val) + FindPath(root.right, target -
 * root.val)) 
 * Description:输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author rico
 * @created 2017年5月31日 下午3:49:33
 */
public class Solution1 {
	public ArrayList<LinkedList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) {  // 递归终止条件1 ： 根结点为空，直接返回
			ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
			return list;
		} else if (root.left == null && root.right == null) {  // 递归终止条件2 ： 叶节点时的处理
			if (root.val == target) {   // 叶节点刚好等于目标值
				ArrayList<LinkedList<Integer>> list1 = new ArrayList<LinkedList<Integer>>();
				LinkedList<Integer> list2 = new LinkedList<Integer>();
				list2.add(root.val);
				list1.add(list2);
				return list1;
			}
			return null;  // 叶节点不等于目标值
		} else {
			ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
			ArrayList<LinkedList<Integer>> left = FindPath(root.left, target
					- root.val);  // 递归调用，缩小范围
			ArrayList<LinkedList<Integer>> right = FindPath(root.right, target
					- root.val);  // 递归调用，缩小范围
			
			if (left != null || right != null) {  // 存在所要求的路径，将当前结点加入路径中
				if (left != null) {
					for (LinkedList<Integer> list1 : left) {
						list1.push(root.val);
						result.add(list1);
					}
				}
				if (right != null) {
					for (LinkedList<Integer> list1 : right) {
						list1.push(root.val);
						result.add(list1);
					}
				}
				return result;
			} else {    // 不存在所要求的路径，直接返回 null
				return null;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTree.createBinaryTree(
				"2(3(2(2,3),4),5(0(2,),2(,1)))", null);
		BinaryTree.printBinaryTree(root);
		System.out.println();
		System.out.println("----------------");
		ArrayList<LinkedList<Integer>> paths = new Solution1()
				.FindPath(root, 10);
		for (LinkedList<Integer> arrayList : paths) {
			System.out.println(arrayList);
		}
	}

}