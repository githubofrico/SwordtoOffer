package Offer60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Title:按之字形顺序打印二叉树
 * Description:请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印
 * ，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author rico
 * @created 2017年7月8日 上午7:45:27
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (pRoot == null) {
			return result;
		}else{
			queue.add(pRoot);
			int count1 = 1;    // 记录当前层的节点个数
			int count2 = 0;    // 记录当前层的下一层的节点个数
			boolean flag = false;    // 标识打印方向
			while (!queue.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();  // 存放每一层节点
				TreeNode tmp = null;
				while(count1 > 0){   // 依次打印当前层节点并将下一层节点入队，同时记录下一层节点的个数
					tmp = queue.pop();   // 当前层节点依次出队
					if (tmp.left != null) {  // 当前层节点的左孩子入队
						queue.add(tmp.left);
						count2 ++;
					}
					if (tmp.right != null) {  // 当前层节点的右孩子入队
						queue.add(tmp.right);
						count2 ++;
					}
					list.add(tmp.val);
					count1 --;
				}
				if (flag) {  // 控制打印方向
					Collections.reverse(list);
				}
				result.add(list);
				count1 = count2;
				count2 = 0;
				flag = !flag;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		
		Solution s = new Solution();
		System.out.println(s.Print(node1));
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