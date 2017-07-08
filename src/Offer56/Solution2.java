package Offer56;

/**
 * Title: 链表中环的入口结点(链表尾节点的指向) 
 * Description: 一个链表中包含环，请找出该链表的环的入口结点，空间复杂度O(1)
 * 
 * @author rico
 * @created 2017年7月6日 下午4:14:08
 */
public class Solution2 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null)
			return null;
		ListNode p1 = pHead, p2 = pHead;  	// 快慢指针，一个一次走一步，一个一次走两步
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {  // 找到环中相汇点
				// 找环中的入口点
				p2 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				if (p1 == p2)
					return p1;
			}
		}
		return null;
	}
}
