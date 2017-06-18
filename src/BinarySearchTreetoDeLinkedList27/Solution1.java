package BinarySearchTreetoDeLinkedList27;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title: 二叉搜索树与双向链表(
 * 方法 ：中序遍历(二叉搜索树的中序遍历结果是有序序列) + 设置指针，需要O(n)辅助空间
 * Description:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author rico
 * @created 2017年6月18日 上午10:30:03
 */
public class Solution1 {
	public TreeNode Convert(TreeNode pRootOfTree) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		//中序遍历的非递归算法
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  // 辅助栈
		TreeNode cur = pRootOfTree;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else{
				cur = stack.pop();
				list.add(cur);   // 当前节点入栈
				cur =cur.right;
			}
		}
		
		System.out.println(list); 
		
		// 设置指针
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size()) {
				list.get(i).right = list.get(i+1);
				list.get(i+1).left = list.get(i);
			}
		}
		return pRootOfTree == null ? null : list.get(0);
	}
}
