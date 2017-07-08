package Offer57;

/**
 * Title:删除链表中重复的结点(双指针法)
 * Description:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author rico
 * @created 2017年7月6日 下午4:28:30
 */
public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead != null) {
			ListNode p1 = pHead; // 慢指针
			ListNode p2 = pHead.next; // 快指针
			ListNode tmp = null; // 去掉重复结点
			ListNode head = null; // 最终结果链表表头
			boolean flag = false; // 两连续节点重复时置为true
			while (p2 != null) {
				if (p1.val != p2.val) { // p1与p2不重复
					if (!flag && head == null) { // 头结点的处理
						head = p1;
					}
					if (flag) {
						if (tmp != null) {
							tmp.next = p2;
						}
						flag = false;
					} else {
						tmp = p1;
					}
					p1 = p2;
					p2 = p2.next;
				} else { // p1与p2重复
					flag = true;
					p2 = p2.next;
				}
			}
			if (flag && tmp != null) { // 尾节点的处理
				tmp.next = null;
			}
			if (!flag && head == null) { // 头结点的处理
				head = p1;
			}
			return head;
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}