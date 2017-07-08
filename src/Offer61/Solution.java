package Offer61;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title: 把二叉树打印成多行(与Offer61类似，只是不用控制打印方向)
 * Description:从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author rico
 * @created 2017年7月8日 上午9:16:55
 */
public class Solution {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (pRoot == null) {
			return result;
		}else{
			queue.add(pRoot);
			int count1 = 1;
			int count2 = 0;
			while (!queue.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				TreeNode tmp = null;
				while(count1 > 0){
					tmp = queue.pop();
					if (tmp.left != null) {
						queue.add(tmp.left);
						count2 ++;
					}
					if (tmp.right != null) {
						queue.add(tmp.right);
						count2 ++;
					}
					list.add(tmp.val);
					count1 --;
				}
				result.add(list);
				count1 = count2;
				count2 = 0;
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