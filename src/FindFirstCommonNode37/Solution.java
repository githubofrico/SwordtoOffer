package FindFirstCommonNode37;

/**
 * Title: 两个链表的第一个公共结点(双指针法，一个指针比另一个指针快)，化解为求相同长度的两链表的第一个相同节点 
 * Description:输入两个链表，找出它们的第一个公共结点。
 * 
 * 时间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月25日 下午3:43:37
 */
public class Solution {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		} else {
			int size1 = size(pHead1);
			int size2 = size(pHead2);
			int num = size1 - size2; // 一个指针比另一个指针快num步
			if (num == 0) { // 两链表长度相等
				return FindFirstCommonNode1(pHead1, pHead2);
			} else if (num > 0) { // 链表pHead1比pHead2长
				ListNode p1 = pHead1;
				int tmp = 0;
				while (tmp < num) {
					p1 = p1.next;
					tmp++;
				}
				return FindFirstCommonNode1(p1, pHead2);
			} else { // 链表pHead2比pHead1长
				num = Math.abs(num);
				ListNode p2 = pHead2;
				int tmp = 0;
				while (tmp < num) {
					p2 = p2.next;
					tmp++;
				}
				return FindFirstCommonNode1(pHead1, p2);
			}
		}
	}

	/**
	 * @description 相同长度的两链表的第一个相同节点
	 * @author rico
	 * @created 2017年6月25日 下午4:34:25
	 */
	public ListNode FindFirstCommonNode1(ListNode p1, ListNode p2) {
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	/**
	 * @description 计算单链表的长度
	 * @author rico
	 * @created 2017年6月25日 下午4:20:31
	 */
	public int size(ListNode pHead) {
		int size = 1;
		ListNode node = pHead;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		return size;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}