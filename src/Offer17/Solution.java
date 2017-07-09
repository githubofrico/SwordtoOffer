package Offer17;

/**
 * Title: 合并两个排序的链表 (迭代循环法)
 * Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author rico
 * @created 2017年6月14日 下午3:59:10
 */
public class Solution {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode target = null;  // 合并后的链表
		ListNode p1 = list1;  // 指向list1的指针
		ListNode p2 = list2;  // 指向list2的指针
		ListNode p3 = null;     // 指向target的最后一个节点
		
		// 从list1和list2中选取一个节点添加到target中 
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				p3 = add(p3, p2);
				p2 = p2.next;
			} else {
				p3 = add(p3, p1);
				p1 = p1.next;
			}
			// target指向链表头结点 
			if (target == null) {
				target = p3;
			}
		}
		
		// 将list1或list2中剩余的节点链入target中 
		if (target != null) {
			if (p1 == null) {
				add(p3, p2);
			} else if (p2 == null) {
				add(p3, p1);
			}
			return target;
		}
		
		// list1和list2至少一个为空的情形
		return p1 == null ? p2 : p1;
	}
	
	  
	/**     
	 * @description 向以p3为头结点的链表中添加节点，并返回该链表中最后一个节点
	 * @author rico       
	 * @created 2017年6月14日 下午5:02:24     
	 * @param target
	 * @param node
	 * @return     
	 */
	public ListNode add(ListNode p3, ListNode node){
		ListNode cur = null;
		if (p3 == null) {
			p3 = node;
			cur = p3;
		}else{
			p3.next = node;
			cur = node;
		}
		return cur;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}