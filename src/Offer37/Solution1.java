package Offer37;

import java.util.LinkedList;

/**
 * Title: 两个链表的第一个公共结点(借助于辅助栈，从后往前开始比较) 
 * Description:输入两个链表，找出它们的第一个公共结点。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月25日 下午3:43:37
 */
public class Solution1 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		} else {
			LinkedList<ListNode> stack1 = getNodes(pHead1);
			LinkedList<ListNode> stack2 = getNodes(pHead2);
			ListNode result = null;
			while (!stack1.isEmpty() && !stack2.isEmpty()) {
				ListNode tmp1 = stack1.pop();
				ListNode tmp2 = stack2.pop();
				if (tmp1 == tmp2) {
					result = tmp1;
				}else{
					break;
				}
			}
			return result;
		}
	}

	/**
	 * @description 单链表的所有节点入栈
	 * @author rico
	 * @created 2017年6月25日 下午4:20:31
	 */
	public LinkedList<ListNode> getNodes(ListNode pHead) {
		LinkedList<ListNode> stack = new LinkedList<ListNode>();
		ListNode node = pHead;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		return stack;
	}
}