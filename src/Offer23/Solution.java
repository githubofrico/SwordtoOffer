package Offer23;

import java.util.ArrayList;
import java.util.LinkedList;
/**        
 * Title: 从上往下打印二叉树(二叉树的广序遍历：辅助队列)
 * Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author rico       
 * @created 2017年6月16日 上午9:30:36    
 */      
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  // 辅助队列
		while(root != null || !queue.isEmpty()) {
			if (root != null) {   // 当前节点不为空时，遍历该节点并将其子女入队
				list.add(root.val);
				queue.add(root.left);
				queue.add(root.right);
			}
			root = queue.pop();  // 从队头获取元素
		}
		return list;
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